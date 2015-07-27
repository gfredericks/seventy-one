(ns com.gfredericks.seventy-one-test
  (:require #?(:clj [clojure.test :refer :all]
               :cljs [cljs.test :refer-macros [deftest is run-tests]])
            #?(:clj [clojure.test.check.generators :as gen]
               :cljs [cljs.test.check.generators :as gen])
            #?(:clj [clojure.test.check.properties :as prop]
               :cljs [cljs.test.check.properties :as prop :include-macros true])
            #?(:clj [clojure.test.check.clojure-test :refer [defspec]]
               :cljs [cljs.test.check.cljs-test :refer-macros [defspec]])
            #?(:clj [clojure.test.check :as tc]
               :cljs [cljs.test.check :as tc])
            [com.gfredericks.seventy-one :refer [seventy-one]]))

(deftest seventy-one-test
  (is (= 71 seventy-one)))

(defspec seventy-one-is-never-not-71
         100
         (prop/for-all [v (gen/such-that #(not= % 71) gen/int)]
                       (not= v seventy-one)))

#?(:cljs
   (do (enable-console-print!)

       (defmethod cljs.test/report [:cljs.test/default :end-run-tests] [m]
         (if (cljs.test/successful? m)
           (println "Success!")
           (println "FAIL")))

       (run-tests 'com.gfredericks.seventy-one-test)))
