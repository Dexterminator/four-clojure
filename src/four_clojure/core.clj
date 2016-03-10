(ns four-clojure.core
  (:gen-class))

(fn gcd [a b] (if (zero? b) a (recur b (mod a b))))

(= (gcd 1023 858) 33)

