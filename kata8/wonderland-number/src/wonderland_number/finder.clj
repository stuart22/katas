(ns wonderland-number.finder)



(defn SameDigits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn wonderland-number []
  (let [possible-nums (range 100000 999999)
        same-dig2 (filter #(SameDigits? %1 (* 2 %1)) possible-nums)
        same-dig3 (filter #(SameDigits? %1 (* 3 %1)) same-dig2)
        same-dig4 (filter #(SameDigits? %1 (* 4 %1)) same-dig3)
        same-dig5 (filter #(SameDigits? %1 (* 5 %1)) same-dig4)
        wonder-num (filter #(SameDigits? %1 (* 6 %1)) same-dig5)]
   (first  wonder-num)))
