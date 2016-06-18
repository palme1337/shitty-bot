(ns shitty-bot.middleware
  (:require [config.core :refer [env]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring.middleware.reload :refer [wrap-reload]]))


(defonce very-insecure-settings {
                                 :security {:anti-forgery false}
                                 })


(defn wrap-dev [handler]
  (fn [req]
    (if (env :dev)
      (-> handler
          (wrap-defaults (merge site-defaults very-insecure-settings))
          wrap-exceptions
          wrap-reload))
    (handler req)))


(defn wrap-middleware [handler]
  (-> handler
      wrap-json-body
      wrap-dev))