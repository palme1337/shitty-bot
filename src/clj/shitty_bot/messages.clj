(ns shitty-bot.messages
  (:require [ajax.core :refer [POST json-request-format]]
            [cheshire.core :refer [generate-string]]))

(defonce bot-key "96ebc51df7a1fb860a5d1ee1f0")
(defonce end-point "https://api.groupme.com/v3/bots/post")

(defonce outgoing-message {:bot_id bot-key})

(defn handle-incoming-message [params] (print params) (print params) (print params) )

(defn send-message [params]
  "Sends a message to dev group me"
  (println params)
  (println (generate-string params))
  (println (generate-string
           (assoc outgoing-message :text "hiu")))
  (POST end-point
        {:handler #(-> % print)
         :params  (assoc outgoing-message :text "hiu")
         :format  (json-request-format)})
  "okay")