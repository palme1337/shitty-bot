(ns shitty-bot.server
  (:require [shitty-bot.handler :refer [app]]
            [config.core :refer [env]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main [& args]
    (run-jetty app {:port (Integer/parseInt (or(env :port) "3000")) :join? false}))
