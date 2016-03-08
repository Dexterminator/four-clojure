(ns four-clojure.solutions)

;26. Write a function which returns the first X fibonacci numbers.
(fn [n]
  (->> (iterate #(vector (second %) (apply + %)) [1 1])
       (take n)
       (map first)))

;27. Write a function which returns true if the given sequence is a palindrome.
(fn [coll] (= (seq coll) (reverse coll)))

;28. Write a function which flattens a sequence.
(fn [x]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq x))))

;29. Write a function which takes a string and returns a new string containing only the capital letters.
(fn [string]
  (apply str (filter #(Character/isUpperCase %) string)))

;30. Write a function which removes consecutive duplicates from a sequence.
(fn [coll]
  (reduce (fn [compressed val]
            (if (= (last compressed) val)
              compressed
              (conj compressed val)))
          [(first coll)]
          (rest coll)))

;32. Write a function which duplicates each element of a sequence.
(fn [coll] (mapcat #(vector % %) coll))

;33. Write a function which replicates each element of a sequence a variable number of times.
(fn [coll n] (mapcat #(repeat n %) coll))

;34. Write a function which creates a list of all integers in a given range.
(fn [from to] (take (- to from) (iterate inc from)))

;38. Write a function which takes a variable number of parameters and returns the maximum value.
(fn [& args]
  (reduce (fn [maximum new] (if (> new maximum) new maximum)) args))

;39. Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
(fn [lst1 lst2]
  (loop [x (seq lst1)
         y (seq lst2)
         interleaved []]
    (if (and x y)
      (recur (seq (rest x)) (seq (rest y)) (conj interleaved (first x) (first y)))
      interleaved)))

;40. Write a function which separates the items of a sequence by an arbitrary value.
(fn [separator lst]
  (reduce (fn [interposed val]
            (conj interposed separator val))
          (vector (first lst))
          (rest lst)))

(fn [sep lst] (drop-last (interleave lst (repeat sep))))

;41. Write a function which drops every Nth item from a sequence.
(fn [coll n]
  (keep-indexed (fn [i item] (if (not= 0 (mod (inc i) n)) item)) coll))

;42. Write a function which calculates factorials.
(fn [n]
  (reduce * (range 1 (inc n))))

;43. Write a function which reverses the interleave process into x number of subsequences.
(fn[lst n]
  (apply map vector (partition n lst)))

;44. Write a function which can rotate a sequence in either direction.
(fn [rotation lst]
  (let [n (mod rotation (count lst))]
    (flatten (reverse (split-at n lst)))))

;46. Write a higher-order function which flips the order of the arguments of an input function.
(defn [fun]
  (fn [& args] (apply fun (reverse args))))

;49. Write a function which will split a sequence into two parts.
(fn [n coll] [(take n coll) (drop n coll)])

;50. Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences.
(fn [coll] (vals (group-by type coll)))

;53. Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers.
(fn [coll]
  (letfn [(all-subseqs [coll]
            (reductions (fn [increasing val]
                          (if (> val (last increasing))
                            (conj increasing val)
                            [val]))
                        [(first coll)]
                        (rest coll)))]
    (let [longest
          (first (sort-by count > (all-subseqs coll)))]
      (if (>= (count longest) 2) longest []))))

;54. Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
(fn [n coll]
  (loop [res [] remaining coll]
    (if (> n (count remaining))
      res
      (let [[part tail] (split-at n remaining)]
        (recur (conj res part) tail)))))
