(ns four-clojure.core
  (:gen-class))

(defn my-iterate
  [f x]
  (lazy-seq (cons x (my-iterate f (f x)))))

(fn [f x] (lazy-seq (cons x (my-iterate f (f x)))))

(= (take 5 (my-iterate #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 (my-iterate inc 0)) (take 100 (range)))
(= (take 9 (my-iterate #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

