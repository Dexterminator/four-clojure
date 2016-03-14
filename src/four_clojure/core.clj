(ns four-clojure.core
  (:gen-class))

(defn word-sort
  [sentence]
  (sort-by clojure.string/lower-case (re-seq #"\w+" sentence)))

(word-sort "Have a nice day.")

(= (word-sort  "Have a nice day.")
   ["a" "day" "Have" "nice"])
(= (word-sort  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
(= (word-sort  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
