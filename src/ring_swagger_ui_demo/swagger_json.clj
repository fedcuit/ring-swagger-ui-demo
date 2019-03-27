(ns ring-swagger-ui-demo.swagger-json
  (:require [ring.swagger.swagger2 :as rs]
            [schema.core :as s]))

(s/defschema User {:id s/Str,
                   :name s/Str
                   :address {:street s/Str
                             :city (s/enum :tre :hki)}})

(def swagger-json (rs/swagger-json {:info {:title       "Project X"
                                           :description "Project X - To the Mars"}
                                    :tags [{:name "user"
                                            :description "User stuff"}]
                                    :paths {"/api/ping" {:get {}}
                                            "/user/:id" {:post {:summary "User Api"
                                                                :description "User Api description"
                                                                :tags ["user"]
                                                                :parameters {:path {:id s/Str}
                                                                             :body User}
                                                                :responses {200 {:schema User
                                                                                 :description "Found it!"}
                                                                            404 {:description "Ohnoes."}}}}}}))