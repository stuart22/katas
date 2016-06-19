(ns kata5.core
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer :all]
            [org.httpkit.server :refer [run-server]]
            [clojure.tools.cli :refer :all]
            [clojure.string :as str]
            [clojure.pprint]
            [clojure.java.jdbc :as jdbc]
            [java-jdbc.sql :as sql]
            [korma.db :as korma])
  (:gen-class))

(declare visitor portnum vis-log)

(let [db-host "localhost"
      db-port "5432"
      db-name "kata5db"]

  (def db-spec {:classname "org.postgresql.Driver" ; must be in classpath
                :subprotocol "postgresql"
                :subname (str "//" db-host ":" db-port "/" db-name)
                :user "user"
                :password "mypass"}))
(korma/defdb db (korma/postgres db-spec))


(defn get-visitors [db-spec]
  (jdbc/query db-spec ["SELECT ALL name FROM Visitors"]))

(def vis-log (get-visitors db-spec))


(defn index-page [username]
  (if (nil? username)
      (concat "<form>\n Hello ""Stranger"
              "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form>")
  (do
    (print (str "Username:" username))
    (concat "<form>\n Hello " username
            "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form> <br>" vis-log))))



(defroutes myapp
           (GET "/" request-map (do
                                  (clojure.pprint/pprint request-map)
                                  (def visitor (apply str (last (split-at 5 (:query-string request-map)))))
                                  (jdbc/db-do-commands "postgresql://localhost:5432/kata5db"
                                                       (jdbc/create-table-ddl :Visitors [[:data :text]]))
                                  (jdbc/insert! db-spec :Visitors
                                                {:name visitor})
                                  (index-page visitor))))



(defn -main [& port]
  (do
    (print (str "Starting server on port " (last port)))
    (def portnum (last port))

    (run-server myapp {:port (read-string portnum)})))

