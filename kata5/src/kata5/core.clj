(ns kata5.core
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer :all]
            [org.httpkit.server :refer [run-server]]
            [clojure.tools.cli :refer :all]
            [clojure.string :as str]
            [clojure.pprint]
            [clojure.java.jdbc :as jdbc]
            [java-jdbc.sql :as sql])
  (:gen-class))

(declare visitor portnum vis-log db-spec)



;(korma/defdb db (korma/postgres db-spec))

;(korma/defdb prod (korma/postgres {:db         "kata5db"
;                                   :user       "postgres"
;                                   :password   "katapass"
;                                   ;; optional keys
;                                   :host       "localhost"
;                                   :port       "5432"
;                                   :delimiters ""}))  




(def pg-db {:subprotocol "postgres"
            :subname     "//localhost:5432/kata5db"
            :user        "postgres"
            :password    "katapass"})


(defn index-page [username]
  (if (nil? username)
      (concat "<form>\n Hello ""Stranger"
              "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form>")
  (do
    (print (str "Username:" username))
    (concat "<form>\n Hello " username
            "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form> <br>" vis-log))))


(defn insert-visitor
  [visitors]
  (jdbc/insert! pg-db
                :visitors
                {:name visitors}))
 ;



(defn get-visitors [pg-db]
  (jdbc/query pg-db ["select * from public.visitors"]))

;(def vis-log (get-visitors pg-db))

(defroutes myapp
  (GET "/"
       request-map
       (do
         (clojure.pprint/pprint request-map)
         (def visitor (apply str (last (split-at 5 (:query-string request-map)))))
         (insert-visitor visitor)
         (index-page visitor))))


(defn -main [& port]
  (do
    (print (str "Starting server on port " (last port)))
    (def portnum (last port))

    (run-server myapp {:port (read-string portnum)})))

