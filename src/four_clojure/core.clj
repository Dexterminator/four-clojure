(ns four-clojure.core
  (:gen-class))

(defn max-value
  [& args]
  (reduce (fn [maximum new] (if (> new maximum) new maximum)) args))

(= (max-value 1 8 3 4) 8)
(= (max-value 1 8 3 4) 8)
(= (max-value 30 20) 30)
(max-value 1 2)
