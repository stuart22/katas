(ns kata1.core)

(defn unique-string? [string]
  (cond (= (count (distinct string)) (count string)) true
        :else false))

(defn unqstr [string]
 (loop [ind 0]
   (cond (= ind  (count string)) true
         (not(= ind (clojure.string/last-index-of string (get string ind)))) false
         :else (recur (inc ind)))))



       
(defn reverse-str [string]
  (loop [reversed '()  forward string]
    (cond (= (count reversed) (count string)) (str  reversed)
          :else (recur (cons (str(first forward)) reversed) (map str (rest forward))))))
       
          


(defn is-perm? [str1 str2] 
  (let [str1-contains (set str1)
        str2-contains (set str2)]
    (= (frequencies str1-contains) (frequencies str2-contains))))
