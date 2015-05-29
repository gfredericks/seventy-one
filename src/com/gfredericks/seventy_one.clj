(ns com.gfredericks.seventy-one
  "Namespace containing seventy-ones.")

(def seventy-ones
  "The numbers seventy-one"
  (->> (range 8 37)
       (map #(Long/parseLong "71" %))
       (set)))
