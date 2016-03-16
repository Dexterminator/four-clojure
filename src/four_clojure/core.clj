(ns four-clojure.core
  (:gen-class))

(defn id-kv
  [coll]
  (loop [curr-kw (first coll) mapped {} remaining coll]
    (if (seq remaining)
      (let [v (first remaining)]
        (if (keyword? v)
          (recur v (assoc mapped v []) (rest remaining))
          (recur curr-kw (assoc mapped curr-kw (conj (get mapped curr-kw) v)) (rest remaining))))
      mapped)))

(id-kv [:a 1, :b 2])
(id-kv [:a 1 2 3 :b :c 4])

(= {} (id-kv []))
(= {:a [1]} (id-kv [:a 1]))
(= {:a [1], :b [2]} (id-kv [:a 1, :b 2]))
(= {:a [1 2 3], :b [], :c [4]} (id-kv [:a 1 2 3 :b :c 4]))
