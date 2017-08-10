(ns com.gfredericks.seventy-one
  "Namespace containing seventy-one."
  (:require
    [clojure.spec.alpha :as s]))

(s/def ::seventy-one #{71})

(def seventy-one
  "The number seventy-one, i.e. 71."
  71)
