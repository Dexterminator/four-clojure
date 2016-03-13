(ns four-clojure.core
  (:gen-class))

(defn pascal
  [row]
  (letfn [(pascal-row [row]
            (flatten [(first row) (map #(reduce +' %) (partition 2 1 row)) (last row)]))]
    (iterate pascal-row row)))

(fn [row]
  (letfn [(pascal-row [row]
            (flatten [(first row) (map #(reduce +' %) (partition 2 1 row)) (last row)]))]
    (iterate pascal-row row)))

(second (pascal [2 3 2]))
(take 2 (pascal [3 1 2]))

(= (second (pascal [2 3 2])) [2 5 5 2])
(= (take 5 (pascal [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
(= (take 2 (pascal [3 1 2])) [[3 1 2] [3 4 3 2]])
(= (take 100 (pascal [2 4 2])) (rest (take 101 (pascal [2 2]))))
