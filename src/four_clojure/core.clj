(ns four-clojure.core
  (:gen-class))

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(= (factorial 1) 1)
(= (factorial 3) 6)
(= (factorial 5) 120)
(= (factorial 8) 40320)
