(ns four-clojure.core
  (:gen-class))

(fn [& fns] (fn [& args] (map #(apply % args) fns)))

