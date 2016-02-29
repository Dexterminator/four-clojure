(ns four-clojure.core
  (:gen-class))

(defn reverse-interleave
  [lst n]
  (apply map vector (partition n lst)))

(map vector '(1 2 3) '(4 5 6))
(apply map vector [[1 2 3] [4 5 6]])
(map str ["a" "b" "c"] ["A" "B" "C"])

(reverse-interleave [1 2 3 4 5 6] 2)

(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

