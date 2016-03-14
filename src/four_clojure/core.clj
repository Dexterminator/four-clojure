(ns four-clojure.core
  (:gen-class))

(defn my-reductions
  ([fun [x & xs]]
   (my-reductions fun x xs))
  ([fun val coll]
   (if (seq coll)
     (lazy-seq (cons val (my-reductions fun (fun val (first coll)) (rest coll))))
     [val])))

(defn my-reductions
  ([fun [x & xs]]
   (my-reductions fun x xs))
  ([fun reduced [x & xs]]
   (if x
     (lazy-seq (cons reduced (my-reductions fun (fun reduced x) xs)))
     (vector reduced))))

(my-reductions conj [1] [2 3 4])
(take 5 (my-reductions + (range)))

(= (take 5 (my-reductions + (range))) [0 1 3 6 10])
(= (my-reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (my-reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
