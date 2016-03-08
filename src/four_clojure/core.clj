(ns four-clojure.core
  (:gen-class))

(defn fib
  [n]
  (->> (iterate #(vector (second %) (apply + %)) [1 1])
      (take n)
      (map first)))

(apply + [1 1])
(fib 8)
(= (fib 8) '(1 1 2 3 5 8 13 21))
