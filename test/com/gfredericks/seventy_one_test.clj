(ns com.gfredericks.seventy-one-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer :all]
            [com.gfredericks.seventy-one :refer :all]))

(deftest seventy-one-test
  (is (= 71 seventy-one)))

(defspec seventy-one-is-never-not-71
         100
         (prop/for-all [v (gen/such-that #(not= % 71) gen/int)]
                       (not= v seventy-one)))
