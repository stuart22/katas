
(ns kata5.database
  (:require [korma.db :as korma]
            [lobos.connectivity :as lobos]))

(let [db-host "localhost"
      db-port portnum
      db-name "kata5db"]

  (def db-spec {:classname "org.postgresql.Driver" ; must be in classpath
                :subprotocol "postgresql"
                :subname (str "//" db-host ":" db-port "/" db-name)
                :user "user"
                :password "mypass"}))
(korma/defdb db db-spec)
; set up lobos
(lobos/open-global db-spec)