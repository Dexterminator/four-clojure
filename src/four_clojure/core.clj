(ns four-clojure.core
  (:gen-class))

(fn [n] (fn [x] (int (Math/pow x n))))

((simple-closure 2) 16)

(= 256 ((simple-closure 2) 16),
   ((simple-closure 8) 2))
(= [1 8 27 64] (map (simple-closure 3) [1 2 3 4]))
(= [1 2 4 8 16] (map #((simple-closure %) 2) [0 1 2 3 4]))
