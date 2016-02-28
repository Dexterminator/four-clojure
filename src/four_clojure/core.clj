(ns four-clojure.core
  (:gen-class))

(defn drop-nth
  [coll n]
  (keep-indexed (fn [i item]
                  (if (not= 0 (mod (inc i) n))
                    item))
                coll))

(drop-nth [1 2 3 4 5 6 7 8] 3)
(drop-nth [:a :b :c :d :e :f] 2)
(drop-nth [1 2 3 4 5 6] 4)

(= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])
