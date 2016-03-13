(ns four-clojure.core
  (:gen-class))

(defn sum-squares
  [nums]
  (letfn [(square-sum [num]
            (reduce + (map #(Math/pow (Character/getNumericValue %) 2) (str num))))]
    (count (filter #(> (square-sum %) %) nums))))

(fn [nums]
  (letfn [(square-sum [num]
            (reduce + (map #(Math/pow (Character/getNumericValue %) 2) (str num))))]
    (count (filter #(> (square-sum %) %) nums))))

(sum-squares (range 10))
(= 8 (sum-squares (range 10)))
(= 19 (sum-squares (range 30)))
(= 50 (sum-squares (range 100)))
(= 50 (sum-squares (range 1000)))
