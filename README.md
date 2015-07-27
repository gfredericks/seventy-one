# seventy-one

The number 71 in Clojure[script]

## Obtention

`[com.gfredericks/seventy-one "0.1.1"]`

## Compatibility notes

As of release `0.1.1` seventy-one requires clojure 1.7, as its source
is packaged in the new `.cljc` file format.

## Usage

``` clojure
(require '[com.gfredericks.seventy-one :refer [seventy-one]])

(defn business-logic
  [customer-count]
  ;; add 71 to customer-count
  (+ customer-count seventy-one))
```

## Documentation

Codox docs are [here](http://gfredericks.github.io/seventy-one/).

## License

Copyright © 2015 Gary Fredericks

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
