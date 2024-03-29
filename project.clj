(defproject ring-swagger-ui-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [prismatic/schema "1.1.10"]
                 [metosin/ring-swagger "0.26.1"]
                 [metosin/ring-swagger-ui "3.20.1"]]
  :plugins [[lein-ring "0.12.5"]
            [lein-cljfmt "0.6.3"]]
  :ring {:handler ring-swagger-ui-demo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
