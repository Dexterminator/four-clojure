(ns four-clojure.core
  (:gen-class))

(defn perfect-squares
  [num-str]
  (clojure.string/join
    ","
    (filter (fn [num]
              (let [root (Math/sqrt num)]
                (== root (int root))))
            (map #(Integer/parseInt %) (clojure.string/split num-str #",")))))

(perfect-squares "15,16,25,36,37")
(perfect-squares "4,5,6,7,8,9")
(= (perfect-squares "4,5,6,7,8,9") "4,9")
(= (perfect-squares "15,16,25,36,37") "16,25,36")
