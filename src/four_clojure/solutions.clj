(ns four-clojure.solutions)

;38, Maximum value
(fn [& args]
  (reduce (fn [maximum new] (if (> new maximum) new maximum)) args))


;39
(fn [lst1 lst2]
  (loop [x (seq lst1)
         y (seq lst2)
         interleaved []]
    (if (and x y)
      (recur (seq (rest x)) (seq (rest y)) (conj interleaved (first x) (first y)))
      interleaved)))

;40
(fn [separator lst]
  (reduce (fn [interposed val]
            (conj interposed separator val))
          (vector (first lst))
          (rest lst)))

(fn [sep lst] (drop-last (interleave lst (repeat sep))))


