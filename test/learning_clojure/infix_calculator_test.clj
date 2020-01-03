(ns learning-clojure.infix-calculator-test
  (:require [clojure.test :refer :all]
            [learning-clojure.infix-calculator :refer :all]))

(deftest string-to-int-conversion
  (testing "parsing integers"
    (is (= (parse-int "1") 1))
    (is (= (parse-int "-1") -1))))

(deftest string-to-operator-conversion
  (testing "converting math operation symbol to actual operator"
    (is (= ((string-to-operator "+") 1 3) 4))
    (is (= ((string-to-operator "/") 4 2) 2))))

(deftest executing-string-based-operator
  (testing "executing a string operator on its arguments"
    (is (= (apply-operator "+" "1" "2") 3))))

(deftest infix-calculation
  (testing "handles infix calculation with operator and 2 arguments"
    (is (= (infix-calc "5 + 5") 10)))
  (testing "handles infix calculation with several operators and arguments"
    (is (= (infix-calc "5 * 5 / 5") 5))))
  (testing "does not handle order of operations without parentheses"
    (is (not (= (infix-calc "12 + 4 / 2") 14))))
  (testing "does not handle parentheses"
    (is (thrown? NumberFormatException (= (infix-calc "( 1 + 1 ) * 5") 10))))

