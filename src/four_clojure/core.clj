(ns four-clojure.core
  (:gen-class))

(defn palindrome?
  [coll]
  (= (seq coll) (reverse coll)))

(fn [coll] (= (seq coll) (reverse coll)))
(false? (palindrome? '(1 2 3 4 5)))
(true? (palindrome? "racecar"))
