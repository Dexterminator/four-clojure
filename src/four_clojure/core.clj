(ns four-clojure.core
  (:gen-class))


;(defn pascal-row [row]
;  (flatten [1 (map #(reduce + %) (partition 2 1 row)) 1]))

(defn pascals
  [rownum]
  (letfn [(pascal-row [row]
            (flatten [1 (map #(reduce + %) (partition 2 1 row)) 1]))]
    (last (take rownum (iterate pascal-row [1])))))

(fn [rownum]
  (letfn [(pascal-row [row]
            (flatten [1 (map #(reduce + %) (partition 2 1 row)) 1]))]
    (last (take rownum (iterate pascal-row [1])))))

(pascals 2)
(pascals 4)
(map pascals (range 1 6))
(= (pascals 1) [1])
(= (map pascals (range 1 6))
   [     [1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])
(= (pascals 11)
   [1 10 45 120 210 252 210 120 45 10 1])

