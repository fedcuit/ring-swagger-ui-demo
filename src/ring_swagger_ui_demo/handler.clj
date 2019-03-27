(ns ring-swagger-ui-demo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [ring.swagger.swagger-ui :as swagger]
            [ring-swagger-ui-demo.swagger-json :refer [swagger-json]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/swagger.json" [] (response swagger-json))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (swagger/wrap-swagger-ui)
      (wrap-json-response)
      (wrap-defaults api-defaults)))

(comment)