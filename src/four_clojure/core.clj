(ns four-clojure.core
  (:gen-class))

(defn pairwise-disjoint?
  [sets]
  (empty? (for [set1 sets set2 sets
                :when (and (not= set1 set2) (seq (clojure.set/intersection set1 set2)))]
            [set1 set2])))

(pairwise-disjoint? #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})

(= (pairwise-disjoint? #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true)
(= (pairwise-disjoint? #{#{:a :b :c :d :e}
                         #{:a :b :c :d}
                         #{:a :b :c}
                         #{:a :b}
                         #{:a}})
   false)
(= (pairwise-disjoint? #{#{[1 2 3] [4 5]}
                         #{[1 2] [3 4 5]}
                         #{[1] [2] 3 4 5}
                         #{1 2 [3 4] [5]}})
   true)
(= (pairwise-disjoint? #{#{'a 'b}
                         #{'c 'd 'e}
                         #{'f 'g 'h 'i}
                         #{''a ''c ''f}})
   true)
(= (pairwise-disjoint? #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                         #{#{:x :y :z} #{:x :y} #{:z} #{}}
                         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false)
(= (pairwise-disjoint? #{#{(= "true") false}
                         #{:yes :no}
                         #{(class 1) 0}
                         #{(symbol "true") 'false}
                         #{(keyword "yes") ::no}
                         #{(class '1) (int \0)}})
   false)
(= (pairwise-disjoint? #{#{distinct?}
                         #{#(-> %) #(-> %)}
                         #{#(-> %) #(-> %) #(-> %)}
                         #{#(-> %) #(-> %) #(-> %)}})
   true)
(= (pairwise-disjoint? #{#{(#(-> *)) + (quote mapcat) #_nil}
                         #{'+ '* mapcat (comment mapcat)}
                         #{(do) set contains? nil?}
                         #{,,, #_,, empty?}})
   false)
