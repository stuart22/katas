(defproject kata5 "0.1.0-SNAPSHOT"
  :description "Webserver Hello Stranger w/ Database"
  :url "http://localhost:<some_port>)"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [hiccup "1.0.5"]
                 [http-kit "2.1.16"]
                 [korma "0.4.0"]
                 [org.xerial/sqlite-jdbc "3.7.15-M1"]
                 [java-jdbc/dsl "0.1.3"]
                 [org.clojure/java.jdbc "0.6.1"]]
  :jvm-opts ["-Djava.net.preferIPv4Stack"] 
  :main ^:skip-aot kata5.core
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler kata5.core/myapp}
 )
