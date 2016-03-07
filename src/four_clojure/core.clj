(ns four-clojure.core
  (:gen-class))
(use 'clojure.walk)

(fn [n coll] [(take n coll) (drop n coll)])

(= (my-split 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
