(ns four-clojure.core
  (:gen-class))


(defn symdiff
  [set1 set2]
  (let [union (clojure.set/union set1 set2)
        intersection (clojure.set/intersection set1 set2)]
    (clojure.set/difference union intersection)))

(fn [set1 set2]
  (let [union (clojure.set/union set1 set2)
        intersection (clojure.set/intersection set1 set2)]
    (clojure.set/difference union intersection)))

(symdiff #{1 2 3 4 5 6} #{1 3 5 7})
(= (symdiff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (symdiff #{:a :b :c} #{}) #{:a :b :c})
(= (symdiff #{} #{4 5 6}) #{4 5 6})
(= (symdiff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
