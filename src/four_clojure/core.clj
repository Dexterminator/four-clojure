(ns four-clojure.core
  (:gen-class))

(defn black-box
  [coll]
  (let [fixed-coll (conj (empty coll) [:a :b] [:b :a])]
    (cond
      (= (:a fixed-coll) :b) :map
      (= (conj fixed-coll [:a :b]) fixed-coll) :set
      (= (first fixed-coll) [:b :a]) :list
      (= (first fixed-coll) [:a :b]) :vector)))

(= :map (black-box {:a 1, :b 2}))
(= :list (black-box (range (rand-int 20))))
(= :vector (black-box [1 2 3 4 5 6]))
(= :set (black-box #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map black-box [{} #{} [] ()]))
