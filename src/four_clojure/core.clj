(ns four-clojure.core
  (:gen-class))

(fn [f s]
  (reduce (fn [groups x]
            (update-in groups [(f x)] #(concat % [x])))
          {}
          s))

(my-group-by #(> % 5) [1 3 6 8])
(= (my-group-by #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
(= (my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (my-group-by count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
