(ns four-clojure.core
  (:gen-class))

(defn my-range
  [from to]
  (take (- to from) (iterate inc from)))

(fn [from to] (take (- to from) (iterate inc from)))

(my-range 1 4)
(my-range -2 2)

(= (my-range 1 4) '(1 2 3))
(= (my-range -2 2) '(-2 -1 0 1))
(= (my-range 5 8) '(5 6 7))
