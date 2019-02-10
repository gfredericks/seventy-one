(defproject com.gfredericks/seventy-one "0.1.6-SNAPSHOT"
  :description "71 in Clojure"
  :url "https://github.com/gfredericks/seventy-one"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]]
  :plugins [[codox "0.8.12"]
            [lein-cljsbuild "1.1.7"]]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.9.854"]
                                  [org.clojure/spec.alpha "0.1.123"]
                                  [org.clojure/test.check "0.10.0-alpha2"]]
                   :cljsbuild {:builds [{:source-paths ["src" "test"]
                                         :compiler {:output-to "resources/private/js/unit-test.js"
                                                    :optimizations :whitespace
                                                    :pretty-print true}}]}}})
