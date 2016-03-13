(ns four-clojure.core
  (:gen-class))

(defn rec-card
  [[suit rank]]
  {:suit
   (case suit
     \S :spade
     \D :diamond
     \H :heart
     \C :club)
   :rank
   (case rank
     \2 0
     \3 1
     \4 2
     \5 3
     \6 4
     \7 5
     \8 6
     \9 7
     \T 8
     \J 9
     \Q 10
     \K 11
     \A 12)})


(rec-card "DQ")
(rec-card "H5")

(= {:suit :diamond :rank 10} (rec-card "DQ"))
(= {:suit :heart :rank 3} (rec-card "H5"))
(= {:suit :club :rank 12} (rec-card "CA"))
(= (range 13) (map (comp :rank rec-card str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))
