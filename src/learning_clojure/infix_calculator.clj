(ns learning-clojure.infix-calculator
  (:require [clojure.string :as str]))

(defn parse-int [s]
  (if (number? s)
    s
    (Integer/parseInt (re-find #"\A-?\d+" s))))

(defn string-to-operator
  "Converts basic mathematical string experessions to their clojure operator equivalents."
  [str]
  (resolve (symbol str)))

(defn apply-operator
  "Applies a string respresentation operator to its arguments"
  [operator x y]
  ((string-to-operator operator) (parse-int x) (parse-int y)))

(defn infix-calc
  "Processes infix mathematical notation. Ignores PEMDAS"
  ([input]
   (let [elements (str/split input #" ")]
     (if (> (count elements) 3)
       (let [[x operator y & more] elements]
         (apply infix-calc (cons (infix-calc x operator y) more)))
       (let [[x operator y] elements]
         (apply-operator operator x y)))))
  ([x operator y]
   (apply-operator operator x y))
  ([x operator y & more]
   (apply infix-calc (cons (infix-calc x operator y) more))))

(defn loop-input
  []
  (loop []
    (print "Enter some math: ")
    (flush)
    (let [input (read-line)]
      (if input
       (let [result (infix-calc input)]
         (println "Result: " result)
         (recur))))))
