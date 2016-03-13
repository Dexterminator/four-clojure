(ns four-clojure.core
  (:gen-class))

(defn flatten-map
  [main-map]
  (into {} (for [[key, nested-map] main-map
                 [nested-key nested-val] nested-map] [[key nested-key] nested-val])))

(fn [main-map]
  (into {} (for [[key, nested-map] main-map
                 [nested-key nested-val] nested-map] [[key nested-key] nested-val])))

(flatten-map '{a {p 1, q 2}
               b {m 3, n 4}})

(= (flatten-map '{a {p 1, q 2}
         b {m 3, n 4}})
   '{[a p] 1, [a q] 2
     [b m] 3, [b n] 4})
(= (flatten-map '{[1] {a b c d}
         [2] {q r s t u v w x}})
   '{[[1] a] b, [[1] c] d,
     [[2] q] r, [[2] s] t,
     [[2] u] v, [[2] w] x})
(= (flatten-map '{m {1 [a b c] 3 nil}})
   '{[m 1] [a b c], [m 3] nil})
