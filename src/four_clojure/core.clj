(ns four-clojure.core
  (:gen-class))

(fn [set1 set2] (set (for [x set1 y set2] [x y])))

(cartestian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})

(= (cartestian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})
(= (cartestian-product #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
(= 300 (count (cartestian-product (into #{} (range 10))
                  (into #{} (range 30)))))
