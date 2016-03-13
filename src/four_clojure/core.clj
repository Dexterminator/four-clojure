(ns four-clojure.core
  (:gen-class))

(fn [f coll]
  (when-let [x (first coll)]
    (lazy-seq (cons (f x) (my-map f (rest coll))))))

(defn my-map
  [f coll]
  (when-let [x (first coll)]
    (lazy-seq (cons (f x) (my-map f (rest coll))))))

(first [])

(my-map inc [1 2 3])
(= [3 4 5 6 7]
   (my-map inc [2 3 4 5 6]))
(= (repeat 10 nil)
   (my-map (fn [_] nil) (range 10)))
(= [1000000 1000001]
   (->> (my-map inc (range))
        (drop (dec 1000000))
        (take 2)))

