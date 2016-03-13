(ns four-clojure.core
  (:gen-class))

(defn binary-tree?
  [coll]
  (if (nil? coll)
    true
    (and
      (coll? coll)
      (= 3 (count coll))
      ((complement coll?) (first coll))
      (binary-tree? (second coll))
      (binary-tree? (last coll)))))

(binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
(binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])

(= (binary-tree? '(:a (:b nil nil) nil))
   true)
(= (binary-tree? '(:a (:b nil nil)))
   false)
(= (binary-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)
(= (binary-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)
(= (binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)
(= (binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
   false)
(= (binary-tree? '(:a nil ()))
   false)
