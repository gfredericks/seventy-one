(ns com.gfredericks.seventy-one-test
  (:require [clojure.test :refer :all]
            [com.gfredericks.seventy-one :refer :all]))

(deftest seventy-one-test
  (is (= 71 seventy-one)))

(deftest seventy-two-test
  (is (= 72 seventy-two)))
