

(defproject kata4 "0.1.0-SNAPSHOT"
  :description "Arithmetic Interpreter"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]]
  :main ^:skip-aot kata4.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :jar-name "kata4.jar" 
  :uberjar-name "kata4-uber.jar")
