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
       (palindrome? (:a :b :c))              => false)

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
       (packer [1 2 3 4 5 6 7 8] 3)          => [1 2 4 5 7 8]
       (packer [:a :b :c :d :e :f] 2)        => [:a :c :e]
       (packer [1 2 3 4 5 6] 4)              => [1 2 3 5 6])





(facts "replicator"                      {:exercise 10
                                        :points   1}
       (replicator [1 2 3] 2)                => (1 1 2 2 3 3)
       (replicator [:a :b] 4)                => '(:a :a :a :a :b :b :b :b)
       (replicator [4 5 6] 1)                => '(4 5 6)
       (replicator [[1 2] [3 4]] 2)          => '([1 2] [1 2] [3 4] [3 4])
       (replicator [44 33] 2)                => [44 44 33 33])


(facts "get-caps"                      {:exercise 11
                                          :points   1}
       (replicator "HeLlO, WoRlD!")          => "HLOWRD"
       (replicator "nothing")                => '()
       (replicator "$#A(*&987Zf")            => "AZ")
