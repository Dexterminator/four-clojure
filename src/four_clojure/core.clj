(ns four-clojure.core
  (:gen-class))

(defn my-partition
  [n coll]
  (loop [res [] remaining coll]
    (if (> n (count remaining))
      res
      (let [[part tail] (split-at n remaining)]
        (recur (conj res part) tail)))))

(fn [n coll]
  (loop [res [] remaining coll]
    (if (> n (count remaining))
      res
      (let [[part tail] (split-at n remaining)]
        (recur (conj res part) tail)))))

(println (my-partition 3 (range 9)))
(println (my-partition 3 (range 8)))

(println (= (my-partition 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
(println (= (my-partition 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
(println (= (my-partition 3 (range 8)) '((0 1 2) (3 4 5))))
