(ns kata3.core-test
  (:use kata3.core
        midje.sweet))




(facts "penult-elem"             {:exercise 1
                                     :points   1}
       (penult-elem (list 1 2 3 4 5))        => 4
       (penult-elem ["a" "b" "c"])           => "b"
       (penult-elem [[1 2] [3 4]])           => [1 2])

(facts "sum-all"             {:exercise 2
                                         :points   1}
       (sum-all [1 2 3])                     => 6
       (sum-all (list 0 -2 5 5))             => 8
       (sum-all #{4 2 1})                    => 7
       (sum-all '(0 0 -1))                   => -1
       (sum-all '(1 10 3))                   => 14)


(facts "find-odd"             {:exercise 3
                                     :points   1}
       (find-odd #{1 2 3 4 5})               => '(1 3 5)
       (find-odd [4 2 1 6])                  => '(1)
       (find-odd [2 2 4 6])                  => '()
       (find-odd [1 1 1 3])                  => '(1 1 1 3))


(facts "palindrome?"             {:exercise 4
                               :points   1}
       (palindrome? '(1 2 3 4 5))            => false
       (palindrome? "racecar")               => true
       (palindrome? [:foo :bar :foo])        => true
       (palindrome? '(1 1 3 3 1 1))          => true
       (palindrome? [:a :b :c])              => false)

(facts "duplicator"             {:exercise 5
                                  :points   1}
       (duplicator [1 2 3])                  => '(1 1 2 2 3 3)
       (duplicator [:a :a :b :b])            => '(:a :a :a :a :b :b :b :b)
       (duplicator [[1 2] [3 4]])            => '([1 2] [1 2] [3 4] [3 4]))


(facts "compressor"             {:exercise 6
                                 :points   1}
       (compressor "Leeeeeerrroyyy")         => "Leroy"
       (compressor [1 1 2 3 3 2 2 3])        => '(1 2 3 2 3)
       (compressor [[1 2] [1 2] [3 4] [1 2]])=> '([1 2] [3 4] [1 2]))


(facts "packer"                      {:exercise 7
                                        :points   1}
       (packer [1 1 2 1 1 1 3 3])            => '((1 1) (2) (1 1 1) (3 3))
       (packer [:a :a :b :b :c])             => '((:a :a) (:b :b) (:c))
       (packer [[1 2] [1 2] [3 4]])          => '(([1 2] [1 2]) ([3 4])))

(facts "dropper"                      {:exercise 8
                                       :points   1}
       (dropper [1 2 3 4 5 6 7 8] 3)          => [1 2 4 5 7 8]
       (dropper [:a :b :c :d :e :f] 2)        => [:a :c :e]
       (dropper [1 2 3 4 5 6] 4)              => [1 2 3 5 6])


(facts "iterator"                      {:exercise 9
                                        :points   1}
       (= iterator
          (take 5 (iterate #(+ 3 %) 1)))     => true)


;(facts "replicator"                      {:exercise 10
 ;                                         :points   1}
  ;     (replicator [1 2 3] 2)                => (1 1 2 2 3 3)
   ;    (replicator [:a :b] 4)                => '(:a :a :a :a :b :b :b :b)
    ;   (replicator [4 5 6] 1)                => '(4 5 6)
     ;  (replicator [[1 2] [3 4]] 2)          => '([1 2] [1 2] [3 4] [3 4])
      ; (replicator [44 33] 2)                => [44 44 33 33])


(facts "get-caps"                      {:exercise 11
                                        :points   1}
       (get-caps "HeLlO, WoRlD!")          => "HLOWRD"
       (get-caps "nothing")                => ""
       (get-caps"$#A(*&987Zf")             => "AZ")

(facts "destruct"                      {:exercise 12
                                        :points   1}


       (= [1 2 [3 4 5] [1 2 3 4 5]]
          (let [[a b & c :as d] destruct]
            [a b c d]))                    => true)



(facts "half-truth"                   {:exercise 13
                                       :points   1}


       ;(half-truth false false)                  => false
       (half-truth true false)                   => true
       ;(half-truth true)                         => false
       (half-truth false true false)             => true)
       ;(half-truth true true true)               => false)



(facts "gcd"                      {:exercise 14
                                      :points   1}
       (gcd 2 4) 2)                              => 2
       (gcd 10 5)                                => 5
       (gcd 5 7)                                 => 1
       (gcd 10 23)                               => 2




(facts "simple-closure"                      {:exercise 15
                                            :points   1}
       ((simple-closure 2) 16)                     => 256
       (map (simple-closure 3) [1 2 3 4])          => [1 8 27 64])



(facts "cart-prod"                      {:exercise 16
                                              :points   1}
       (cart-prod #{1 2 3} #{4 5})                 => #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}
       (count (cart-prod (into #{} (range 10))
                         (into #{} (range 30))))   => 300)




(facts "sym-diff"                      {:exercise 15
                                              :points   1}
       (sym-diff #{1 2 3 4 5 6}
                 #{1 3 5 7})                    => #{2 4 6 7}
       (sym-diff #{:a :b :c}
                 #{})                           => #{:a :b :c})

(facts "LCM"                      {:exercise 16
                                   :points   1}
       (LCM 2 3)                               => 6
       (LCM 5 3 7)                             => 105)



(facts "tree?"                      {:exercise 17
                                   :points   1}
       (tree? (:a (:b nil nil) nil))           => true
       (tree? (:a nil ()))                     => false)

(facts "symmetree?"                      {:exercise 18
                                     :points   1}
       (symmetree? :a (:b nil nil) nil)           => true)
       ;(symmetree? :a (:b nil nil))               => false)



(facts "flip-args"                      {:exercise 19
                                          :points   1}
       ((flip-args nth) 2 [1 2 3 4 5])          => 3
       ((flip-args >) 7 8)                      => true)




(facts "rotator"                      {:exercise 20
                                         :points   1}
       (rotator 2 [1 2 3 4 5])          => '(3 4 5 1 2)
       (rotator -2 [1 2 3 4 5])         => '(4 5 1 2 3))


(facts "rev-interleave"                      {:exercise 21
                                       :points   1}
       (rev-interleave [1 2 3 4 5 6] 2)          => '((1 3 5) (2 4 6))
       (rev-interleave (range 10) 5)             => '((0 5) (1 6) (2 7) (3 8) (4 9)))



(facts "split-type"                      {:exercise 22
                                             :points   1}
       (set (split-type [1 :a 2 :b 3 :c]))         => #{[1 2 3] [:a :b :c]}
       (set (split-type [ [1 2] :a [3 4] 5 6 :b])) => #{[[1 2] [3 4]] [:a :b] [5 6]})




