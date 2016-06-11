(ns kata1.core-test
  (:use kata1.core
        midje.sweet))

(facts "unique-string?"             {:exercise 1
                                     :points   1}
       (unique-string? "foo")        => false
       (unique-string? "abc")        => true
       (unique-string? "123,123")    => false
       (unique-string? "aabbcc1122") => false
       (unique-string? "")           => true)

(facts "unique-string-inplace?"     {:exercise 2
                                     :points   1}
       (unique-string? "foo")        => false
       (unique-string? "abc")        => true
       (unique-string? "123123")     => false
       (unique-string? "aabbcc1122") => false
       (unique-string? "")           => true)


(facts "reverse-str"                {:exercise 3
                                     :points   1}
       (reverse-str "abc")           => (apply str(reverse "abc"))
       (reverse-str "bbb")           => (apply str(reverse "bbb"))
       (reverse-str "123123")        => (apply str(reverse "123123"))
       (reverse-str "a1b")           => (apply str(reverse "a1b"))
       (reverse-str "1 1")           => (apply str(reverse "1 1")))

(facts "is-perm?"                   {:exercise 4
                                     :points   1}
       (is-perm? "foo" "oof")        => true
       (is-perm? "fffo" "ffof")      => true
       (is-perm? "fof" "fffo")       => false
       (is-perm? "12345" "321")      => false
       (is-perm? "12 " "1 2")        => true)

(facts "str-compress"               {:exercise 3
                                     :points   1}
       (str-compress "ccbaaa")       => "c2b1a3"
       (str-compress "aabbaaa")      => "a2b2a3"
       (str-compress "ab")           => "a1b1"
       (str-compress "aaabbbccc")    => "a3b3c3")
