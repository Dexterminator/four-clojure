(ns four-clojure.core
  (:gen-class))


(fn [coll] (map-indexed #(vector %2 %1) coll))

(indexes [:a :b :c])

(= (indexes [:a :b :c]) [[:a 0] [:b 1] [:c 2]])

