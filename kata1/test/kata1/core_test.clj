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
       (reverse-str "abc")           => (reverse "abc")
       (reverse-str "bbb")           => (reverse "bbb")
       (reverse-str "123123")        => (reverse "123123")
       (reverse-str "a1b")           => (reverse "a1b")
       (reverse-str "1 1")           => (reverse "1 1"))

(facts "is-perm?"                   {:exercise 4
                                     :points   1}
       (is-perm? "foo" "oof")        => true
       (is-perm? "fffo" "ffof")      => true
       (is-perm? "fof" "fffo")       => false
       (is-perm? "12345" "321")      => false
       (is-perm? "12 " "1 2")        => true)
