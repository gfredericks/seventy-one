(defproject com.gfredericks/seventy-one "0.1.2-SNAPSHOT"
  :description "71 in Clojure"
  :url "https://github.com/gfredericks/seventy-one"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :profiles {:dev {:dependencies
                   [[org.clojure/test.check "0.7.0"]]}}
  :plugins [[codox "0.8.12"]]
  :deploy-repositories [["releases" :clojars]])
