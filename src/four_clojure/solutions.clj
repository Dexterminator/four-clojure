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

;55. Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
(fn [coll]
  (reduce (fn [frequency-map [key val]]
            (assoc frequency-map key (count val)))
          {}
          (group-by identity coll)))

;56. Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
(fn [coll]
  (loop [encountered #{} distinct-list [] remaining coll]
    (if-not (seq remaining)
      distinct-list
      (let [val (first remaining)
            updated-list (if (some #{val} encountered)
                           distinct-list
                           (conj distinct-list val))]
        (recur (conj updated-list val) updated-list (rest remaining))))))

;61. Write a function which takes a vector of keys and a vector of values and constructs a map from them.
#(apply assoc {} (interleave %1 %2))

;62. Given a side-effect free function f and an initial value x write a function which returns an infinite lazy
; sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
(fn my-iterate [f x] (lazy-seq (cons x (my-iterate f (f x)))))

;63. Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f
; applied to each item in s. The value at each key should be a vector of corresponding items in the order they appear in s.
(fn [f s]
  (reduce (fn [groups x]
            (update-in groups [(f x)] #(concat % [x])))
          {}
          s))

;66. Given two integers, write a function which returns the greatest common divisor.
(fn gcd [a b] (if (zero? b) a (recur b (mod a b))))

;81. Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
(fn my-intersection [set1 set2] (set (for [x set1 :when (set2 x)] x)))

;83. Write a function which takes a variable number of booleans. Your function should return true if some of the
; parameters are true, but not all of the parameters are true. Otherwise your function should return false.
(fn [& args] (boolean (and (some false? args) (some true? args))))

;88. Write a function which returns the symmetric difference of two sets.
; The symmetric difference is the set of items belonging to one but not both of the two sets.
(fn [set1 set2]
  (let [union (clojure.set/union set1 set2)
        intersection (clojure.set/intersection set1 set2)]
    (clojure.set/difference union intersection)))

;90. Write a function which calculates the Cartesian product of two sets.
(fn [set1 set2] (set (for [x set1 y set2] [x y])))

;97. Write a function which returns the nth row of Pascal's Triangle.
(fn [rownum]
  (letfn [(pascal-row [row]
            (flatten [1 (map #(reduce + %) (partition 2 1 row)) 1]))]
    (last (take rownum (iterate pascal-row [1])))))

;99. Write a function which multiplies two numbers and returns the result as a sequence of its digits.
(fn[x y] (map #(Character/getNumericValue %) (str (* x y))))

;107. Given a positive integer n, return a function (f x) which computes xn.
; Observe that the effect of this is to preserve the value of n for use outside the scope in which it is defined.
(fn [n] (fn [x] (int (Math/pow x n))))

;118. Given a function f and an input sequence s, return a lazy sequence of (f x) for each element x in s.
(fn my-map [f coll]
  (when-let [x (first coll)]
    (lazy-seq (cons (f x) (my-map f (rest coll))))))

;122. Convert a binary number, provided in the form of a string, to its numerical value.
(fn [bin-str]
  (let [pows (map-indexed (fn [idx num]
                            (Math/pow (* 2 (Character/getNumericValue num)) (+ idx 1)))
                          (reverse bin-str))]
    (/ (int (reduce + pows)) 2)))

;135. Write a function that accepts a variable length mathematical expression consisting of numbers and the operations +, -, *, and /.
(fn [& args]
  (reduce (fn [res [op num]] (op res num))
          (first args)
          (partition 2 (rest args))))

;143. Create a function that computes the dot product of two sequences. You may assume that the vectors will have the same length.
#(reduce + (map * %1 %2))

;157. Transform a sequence into a sequence of pairs containing the original elements along with their index.
(fn [coll] (map-indexed #(vector %2 %1) coll))

;166. Write a function that takes three arguments, a less than operator for the data and two items to compare.
; The function should return a keyword describing the relationship between the two items.
(fn [lt-fn x y]
  (cond
    (lt-fn x y) :lt
    (lt-fn y x) :gt
    :else :eq))