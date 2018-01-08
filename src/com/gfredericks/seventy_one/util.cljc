(ns com.gfredericks.seventy-one.util
  "Utils to help perform typical operations using the number 71."
  (:require
    [clojure.spec.alpha :as s]
    [clojure.spec.gen.alpha :as gen]
    [com.gfredericks.seventy-one :as so]))

(defn seventy-one?
  "Checks whether an object is a number that is equal to seventy
  one. Returns true for integral, decimal, and floating-point
  seventy-ones."
  [x]
  (and (number? x)
       (== x so/seventy-one)))

(def ^:const fast-seventy-one
  "An alternative to `seventy-one` that is optimized for performance
  at the expense of dynamism."
  71)

#?(:clj
   (defmacro ->71
     "Threads the expr through the forms. Inserts x as the second item
  and 71 as the last item in the first form, making a list of it if it
  is not a list already. If there are more forms, inserts the first
  form and 71 into the second form, etc."
     [x & forms]
     (if-let [[form & more] (seq forms)]
       (let [form (if (list? form) form (list form))]
         `(->71
            (~(first form) ~x ~@(rest form) 71)
            ~@more))
       x)))

(defn gen-seventy-one
  "Returns a clojure.test.check generator that generates 71. Useful
  for writing robust test cases for code that uses the number 71."
  []
  (s/gen ::so/seventy-one))
