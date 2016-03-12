(ns four-clojure.core
  (:gen-class))

#(reduce + (map * %1 %2))

(= 0 (dot-product [0 1 0] [1 0 0]))
(= 3 (dot-product [1 1 1] [1 1 1]))
(= 32 (dot-product [1 2 3] [4 5 6]))
(= 256 (dot-product [2 5 6] [100 10 1]))