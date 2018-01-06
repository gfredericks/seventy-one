(ns com.gfredericks.seventy-one-test
  (:require [clojure.spec.alpha :as s]
            #?(:clj [clojure.test :refer :all]
               :cljs [cljs.test :refer-macros [deftest is run-tests]])
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check :as tc]
            [com.gfredericks.seventy-one :refer [seventy-one]]
            [com.gfredericks.seventy-one.util :as util]))

(deftest seventy-one-test
  (is (= 71 seventy-one))
  (is (s/valid? :com.gfredericks.seventy-one/seventy-one seventy-one)))

(defspec seventy-one-is-never-not-71
  100
  (prop/for-all [v (gen/such-that #(not= % 71) gen/int)]
    (not= v seventy-one)))

(defspec seventy-one-generator
  100
  (prop/for-all [v (util/gen-seventy-one)]
    (= v 71)))

(deftest seventy-one?-returns-true-if-it-is-seventy-one
  (is (true? (util/seventy-one? 71)))
  (is (true? (util/seventy-one? 71.0)))
  (is (true? (util/seventy-one? seventy-one))))

(defspec seventy-one?-returns-false-if-it-isn't-seventy-one
  100
  (prop/for-all [v (gen/such-that
                     (complement #{71 71.0})
                     gen/any)]
    (false? (util/seventy-one? v))))

(deftest ->71-test
  (is (= [:a 3 "hi" 71 71]
         (util/->71 [:a 3 "hi"]
                    conj
                    conj)))
  (is (= {:k1 71 :k2 71}
         (util/->71 {}
                    (assoc :k1)
                    (assoc :k2))))
  (is (= #{71}
         (util/->71 #{}
                    conj
                    disj
                    conj)))
  (is (= 30246
         (util/->71 4
                    *
                    +
                    +
                    *))))

#?(:cljs
   (do (enable-console-print!)

       (defmethod cljs.test/report [:cljs.test/default :end-run-tests] [m]
         (if (cljs.test/successful? m)
           (println "Success!")
           (println "FAIL")))

       (run-tests 'com.gfredericks.seventy-one-test)))
