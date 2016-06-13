(ns kata3.core)

(defn penult-elem [my-seq]
  ((comp second reverse) my-seq))


(defn sum-all [my-seq]
  (reduce + my-seq))




(defn find-odd [my-seq]
  (filter odd? my-seq))



(defn palindrome? [my-seq]
  (= (seq my-seq) (reverse (seq my-seq))))




(defn duplicator [my-seq]
  (interleave my-seq my-seq))





(defn compressor [my-seq]
  (let [compressed (map first (partition-by identity my-seq))]
    (if (= (type my-seq) (type "string")) (apply str (map str compressed))
         compressed)))





(defn packer [my-seq]
  (partition-by identity my-seq))




(defn dropper [my-seq n]
  (apply concat (partition-all (dec n) n my-seq)))


(def iterator [1 4 7 10 13])


(defn replicator [my-seq n]
(apply concat (map (fn [char](repeat n char)) my-seq)))

(defn get-caps [my-seq]
  (apply str (re-seq #"[A-Z]+" my-seq)))


(def destruct (range 1 6))



(defn half-truth [& args]
  (and (some true? args)
       (some false? args)))


(defn gcd [a b]
  (if (zero? b) a
      (recur b (mod a b))))

(defn simple-closure [n]
  (fn [b] (int (Math/pow b n))))


(defn cart-prod [a b]
  (set (for [x a y b] [x y])))

(defn sym-diff [a b]
  (clojure.set/union (clojure.set/difference a b)
                     (clojure.set/difference b a)))


(defn LCM [& args]
    (/ (reduce * args) (reduce gcd args)))


(defn tree? [my-seq]
  (or (nil? my-seq)
      (and (sequential? my-seq)
           (= 3 (count my-seq))
           (every? tree? (rest my-seq)))))

(defn symmetree? [node left right]
  (let [mirror? (fn mirror? [a b]
          (cond (not= (sequential? a) (sequential? b)) false
                (sequential? a) (let [[node-a La Ra] a
                                      [node-b Lb Rb] b]
                                  (and (= node-a node-b) (mirror? La Rb) (mirror? Lb Ra)))
                :else (= a b)))]
    (mirror? left right)))

(defn flip-args [f]
  (fn [& args] (apply f (reverse args))))

(defn rotator [dir my-seq]
  (take (count my-seq) (drop (mod dir (count my-seq)) (cycle my-seq))))

(defn rev-interleave [my-seq n]
  (for [i (range n)]
    (take-nth n (drop i my-seq))))


(defn split-type [my-seq]
  (set (vals (group-by type my-seq))))
