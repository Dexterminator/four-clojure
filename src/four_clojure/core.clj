(ns four-clojure.core
  (:gen-class))

(fn [bin-str]
  (let [pows (map-indexed (fn [idx num]
                              (Math/pow (* 2 (Character/getNumericValue num)) (+ idx 1)))
                            (reverse bin-str))]
    (/ (int (reduce + pows)) 2)))

(read-bin "11111111")
(read-bin "1000")
(read-bin "0")

(= 0 (read-bin "0"))
(= 7 (read-bin "111"))
(= 8 (read-bin "1000"))
(= 9 (read-bin "1001"))
(= 255 (read-bin "11111111"))
(= 1365 (read-bin "10101010101"))
(= 65535 (read-bin "1111111111111111"))
