(ns kata4.core
  (:require [clojure.tools.cli :refer [cli]]
            [clojure.string :as str])
  (:gen-class))

(defn parser [str]
  (str/split str #" "))

(defn str-to-op [& args]
  (loop [ops []
         remaining (rest (parser (get args 0)))]
    (if (empty? remaining) ops
        (recur (conj ops (resolve (symbol (first remaining))))
               (rest (rest remaining))))))


(defn str-to-int [& args]
  (loop [ints []
         remaining (parser  args )]
    (if (empty? remaining) ints
        (recur (conj ints (Integer/parseInt (first remaining)))
               (rest (rest remaining))))))


(defn inter [& args]
  (let [ints (str-to-int args)
        ops  (str-to-op args)]
   (conj (interleave ints ops) (last ints))))


(defn solver [& args]
  (loop [[arg & args] (inter args)
         val          0 
         op           +]
    (cond  (nil? arg)    val
           (number? arg) (recur args (op val arg) nil)
           :else         (recur args val arg))))


(defn -main [& args]
    (let [[opts args banner]
          (cli args
               ["-h" "--help" "Show help" :flag true :default false])]
      (when (:help opts)
        (println "The interpreter takes arguments in the following format:"
                 \newline " int operator int operator int..." 
                 "(sequence must start/end with ints)"
                 \newline "The interpretor accepts"  
                 " + - / * as valid operators." ) 
        (System/exit 0))
     (println (solver args))))

