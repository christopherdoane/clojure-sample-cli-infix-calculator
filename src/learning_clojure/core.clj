(ns learning-clojure.core
  (:require [learning-clojure.infix-calculator :as calc])
  (:gen-class))

(defn -main
  "Production"
  [& args]
  (calc/loop-input))
