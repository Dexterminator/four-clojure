(ns four-clojure.core
  (:gen-class))

;(defn my-frequencies
;  [coll]
;  (into {} (map (fn [[key val]] [key (count val)])) (group-by identity coll)))

(defn my-frequencies
  [coll]
  (reduce (fn [frequency-map [key val]]
            (assoc frequency-map key (count val)))
          {}
          (group-by identity coll)))

(fn [coll]
  (reduce (fn [frequency-map [key val]]
            (assoc frequency-map key (count val)))
          {}
          (group-by identity coll)))

((fn [coll]
   (into {} (map (fn [[key val]] [key (count val)])) (group-by identity coll))) [1 1 2 3 2 1 1])

(my-frequencies [1 1 2 3 2 1 1])
(my-frequencies [:b :a :b :a :b])
(my-frequencies '([1 2] [1 3] [1 3]))
(= (my-frequencies [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
(= (my-frequencies [:b :a :b :a :b]) {:a 2, :b 3})
(= (my-frequencies '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
