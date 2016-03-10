(ns four-clojure.core
  (:gen-class))

(defn comparisons
  [lt-fn x y]
  (cond
    (lt-fn x y) :lt
    (lt-fn y x) :gt
    :else :eq))

(comparisons < 5 1)
(comparisons (fn [x y] (< (count x) (count y))) "pear" "plum")
(comparisons (fn [x y] (< (mod x 5) (mod y 5))) 21 3)
(comparisons > 0 2)
(= :gt (comparisons < 5 1))
(= :eq (comparisons (fn [x y] (< (count x) (count y))) "pear" "plum"))
(= :lt (comparisons (fn [x y] (< (mod x 5) (mod y 5))) 21 3))
(= :gt (comparisons > 0 2))

