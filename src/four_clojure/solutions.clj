(ns four-clojure.solutions)

;27, Palindrome Detector
(fn [coll] (= (seq coll) (reverse coll)))

; 28. Flatten a Sequence
(fn [x]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq x))))

;32, Duplicate a Sequence
(fn [coll] (mapcat #(vector % %) coll))

;38, Maximum value
(fn [& args]
  (reduce (fn [maximum new] (if (> new maximum) new maximum)) args))


;39, Interleave Two Seqs
(fn [lst1 lst2]
  (loop [x (seq lst1)
         y (seq lst2)
         interleaved []]
    (if (and x y)
      (recur (seq (rest x)) (seq (rest y)) (conj interleaved (first x) (first y)))
      interleaved)))

;40, Interpose a Seq
(fn [separator lst]
  (reduce (fn [interposed val]
            (conj interposed separator val))
          (vector (first lst))
          (rest lst)))

;or
(fn [sep lst] (drop-last (interleave lst (repeat sep))))

;41, Drop Every Nth Item
(fn [coll n]
  (keep-indexed (fn [i item] (if (not= 0 (mod (inc i) n)) item)) coll))

;42, Factorial Fun
(fn [n]
  (reduce * (range 1 (inc n))))

;43, Reverse Interleave
(fn[lst n]
  (apply map vector (partition n lst)))

;44, Rotate Sequence
(fn [rotation lst]
  (let [n (mod rotation (count lst))]
    (flatten (reverse (split-at n lst)))))

;46, Flipping Out
(defn [fun]
  (fn [& args] (apply fun (reverse args))))

;49  Split a sequence
(fn [n coll] [(take n coll) (drop n coll)])
