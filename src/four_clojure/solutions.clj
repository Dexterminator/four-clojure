(ns four-clojure.solutions)

;38, Maximum value
(fn [& args]
  (reduce (fn [maximum new] (if (> new maximum) new maximum)) args))


