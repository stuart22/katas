(ns kata1.core
  (:require [clojure.string :as str]))

(defn unique-string? [string]
  (cond (>= (apply max (vals (frequencies string))) 2) false
        :else                                          true))


(defn reverse-str [string]
  (loop [reversed '()
         forward string]
    (cond (= (count reversed)
             (count string))  (apply str reversed)
          :else              (recur (cons (first forward) reversed)
                                    (rest forward)))))


(defn unique-string-inplace? [s]
  (loop [ind 0]
    (cond (= ind (count s))                                               true
          (loop [subind 0 char (get s ind)]
            (cond (= char (get (subs (reverse-str s) 0 ind) subind)) true
                  (= subind (count (subs (reverse-str s 0 ind))))    false
                  :else (recur (inc subind) (char))))                     false
          :else  (recur (inc ind)))))



(defn is-perm? [str1 str2] 
    (= (frequencies str1) (frequencies str2)))



(defn str-compress [s]
  (let [compressed (apply str (apply concat (map (juxt first count)
                                                 (partition-by identity s))))]
    (if (>= (count compressed) (count s)) s
        compressed)))


