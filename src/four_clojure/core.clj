(ns four-clojure.core
  (:gen-class))

;(defn my-interpose
;  [separator lst]
;  (reduce (fn [interposed val]
;            (conj interposed separator val))
;          (vector (first lst))
;          (rest lst)))
(defn my-interpose
  [sep lst]
  (drop-last (interleave lst (repeat sep))))

(= (my-interpose 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose ", " ["one" "two" "three"]) "one, two, three"))
(= (my-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
