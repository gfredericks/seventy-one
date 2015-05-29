(ns com.gfredericks.seventy-one-test
  (:require [clojure.test :refer :all]
            [com.gfredericks.seventy-one :refer :all]))

(deftest seventy-ones-test
  (is (not= (repeat 70 1) seventy-ones)))

(deftest seventy-one-test
  (is :seventy-one))
