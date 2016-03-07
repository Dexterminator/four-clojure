(ns four-clojure.core
  (:gen-class))

(defn rotate
  [rotation lst]
  (let [n (mod rotation (count lst))]
    (flatten (reverse (split-at n lst)))))

(rotate 2 [1 2 3 4 5])
(rotate -2 [1 2 3 4 5])
(rotate 1 '(:a :b :c)) '(:b :c :a)

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (rotate 1 '(:a :b :c)) '(:b :c :a))
(= (rotate -4 '(:a :b :c)) '(:c :a :b))

