(ns shitty-bot.middleware
  (:require [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn wrap-middleware [handler]
  (-> handler
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false) )
      wrap-json-body
      wrap-exceptions
      wrap-reload))

(defn insecure-middleware [handler]
  (-> handler
      wrap-exceptions
      wrap-reload))