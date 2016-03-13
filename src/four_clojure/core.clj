(ns four-clojure.core
  (:gen-class))

;(defn lcm
;  [& nums])

(defn lcm
  [& nums]
  (letfn [(gcd [a b] (if (zero? b) a (recur b (mod a b))))]
    (reduce #(/ (* %1 %2) (gcd %1 %2)) nums)))

(lcm 2 3)
(== (lcm 2 3) 6)
(== (lcm 5 3 7) 105)
(== (lcm 1/3 2/5) 2)
(== (lcm 3/4 1/6) 3/2)
(== (lcm 7 5/7 2 3/5) 210)
