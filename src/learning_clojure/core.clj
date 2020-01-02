(ns learning-clojure.core
  (:require [learning-clojure.infix-calculator :as calc]))

(defn -main
  "Production"
  [& args]
  (calc/loop-input))
