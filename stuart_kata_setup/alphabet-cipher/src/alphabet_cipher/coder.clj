(ns alphabet-cipher.coder
  (:require [clojure.string :as str]))

(defn letter-to-int [letter]
  (cond (= letter "a") 1
        (= letter "b") 2
        (= letter "c") 3
        (= letter "d") 4
        (= letter "e") 5
        (= letter "f") 6
        (= letter "g") 7
        (= letter "h") 8
        (= letter "i") 9
        (= letter "j") 10
        (= letter "k") 11
        (= letter "l") 12
        (= letter "m") 13
        (= letter "n") 14
        (= letter "o") 15
        (= letter "p") 16
        (= letter "q") 17
        (= letter "r") 18
        (= letter "s") 19
        (= letter "t") 20
        (= letter "u") 21
        (= letter "v") 22
        (= letter "w") 23
        (= letter "x") 24
        (= letter "y") 25
        (= letter "z") 26
        :else "Invalid letter"))

(def alphabet "abcdefghijklmnopqrstuvwxyz")


(defn rotate-to [letter]
  (take-last 26 (take (+ (letter-to-int letter) 25) (cycle alphabet))))

(defn make-key [keyword message]
  (take (count message) (cycle keyword)))

        
(defn encode [keyword message]
  (loop [encoded []
         key (make-key keyword message)
         message-rem message]
    (cond (empty? message-rem)
          (apply str encoded)
          :else  (recur (conj encoded (str (get (apply str(rotate-to (str(first key))))
                                           (- (letter-to-int (str(first message-rem))) 1))))
                        (rest key)
                        (rest message-rem)))))


(defn board-reverse [key-let]
  (loop [alph-str (cycle alphabet)]
    (cond (= (get alph-str (- 1 (letter-to-int key-let)))
             (encode  
         
                      

(defn decode [keyword message]
  (loop [encoded []
         key (make-key keyword message)
         message-rem message]
    (cond (empty? message-rem)
          (apply str encoded)
          :else  (recur (conj encoded (str (get (apply str(rotate-to (str(first key))))
                                                (- (letter-to-int (str(first message-rem))) 1))))
                        (rest key)
                        (rest message-rem)))))

(defn decipher [cipher message]
  "decypherme")

  
