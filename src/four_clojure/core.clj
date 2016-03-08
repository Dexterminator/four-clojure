(ns four-clojure.core
  (:gen-class))

(fn lis
  [coll]
  (letfn [(all-subseqs [coll]
            (reductions (fn [increasing val]
                          (if (> val (last increasing))
                            (conj increasing val)
                            [val]))
                        [(first coll)]
                        (rest coll)))]
    (let [longest
          (first (sort-by count > (all-subseqs coll)))]
      (if (>= (count longest) 2) longest []))))

(lis [5 1 2 3])
(lis [5 6 1 3 2 7])
(lis [7 6 5 4])

(= (lis [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (lis [5 6 1 3 2 7]) [5 6])
(= (lis [2 3 3 4 5]) [3 4 5])
(= (lis [7 6 5 4]) [])
