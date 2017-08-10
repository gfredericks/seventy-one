(ns com.gfredericks.seventy-one-test
  (:require [clojure.spec.alpha :as s]
            #?(:clj [clojure.test :refer :all]
               :cljs [cljs.test :refer-macros [deftest is run-tests]])
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check :as tc]
            [com.gfredericks.seventy-one :refer [seventy-one]]))

(deftest seventy-one-test
  (is (= 71 seventy-one))
  (is (s/valid? :com.gfredericks.seventy-one/seventy-one seventy-one)))

(defspec seventy-one-is-never-not-71
  100
  (prop/for-all [v (gen/such-that #(not= % 71) gen/int)]
    (not= v seventy-one)))

(defspec seventy-one-is-always-71
  100
  (prop/for-all [v (s/gen :com.gfredericks.seventy-one/seventy-one)]
    (= v 71)))

#?(:cljs
   (do (enable-console-print!)

       (defmethod cljs.test/report [:cljs.test/default :end-run-tests] [m]
         (if (cljs.test/successful? m)
           (println "Success!")
           (println "FAIL")))

       (run-tests 'com.gfredericks.seventy-one-test)))
