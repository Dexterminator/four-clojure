(ns four-clojure.core
  (:gen-class))

(defn infix-calc
  [& args]
  (reduce (fn [res [op num]] (op res num))
          (first args)
          (partition 2 (rest args))))

(fn [& args]
  (reduce (fn [res [op num]] (op res num))
          (first args)
          (partition 2 (rest args))))

(infix-calc 38 + 48 - 2 / 2)

(= 7  (infix-calc 2 + 5))
(= 42 (infix-calc 38 + 48 - 2 / 2))
(= 8  (infix-calc 10 / 2 - 1 * 2))
(= 72 (infix-calc 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))
