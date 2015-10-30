(defproject c2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [edgewise "0.1.0-SNAPSHOT" ]]
  :main ^:skip-aot c2.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[speclj "3.3.0"]]}}
  :plugins [[speclj "3.3.0"]]
  :test-paths ["spec"]
  )
