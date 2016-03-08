(ns four-clojure.core
  (:gen-class))

(defn compress
  [coll]
  (reduce (fn [compressed val]
            (if (= (last compressed) val)
              compressed
              (conj compressed val)))
          [(first coll)]
          (rest coll)))

(= (apply str (compress "Leeeeeerrroyyy")) "Leroy")
(= (compress [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (compress [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

