(ns com.gfredericks.seventy-one-test
  (:require [cljs.test :refer-macros [deftest is]]
            [com.gfredericks.seventy-one :refer [seventy-one]]))

(deftest seventy-one-test
  (is (= 71 seventy-one)))

(do (enable-console-print!)
    (cljs.test/run-tests))

