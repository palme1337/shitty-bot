(ns shitty-bot.messages
  (:require [ajax.core :refer [POST json-request-format]]
            [cheshire.core :refer [generate-string]]))

(defonce bot-key "96ebc51df7a1fb860a5d1ee1f0")
(defonce end-point "https://api.groupme.com/v3/bots/post")

(defonce outgoing-message {:bot_id bot-key})

(defn handle-incoming-message [params] (println params) (println params) (println params) "OK")

(defn send-message [params]
  "Sends a message to dev group me"
  (println "Sending a message")
  (println (get-in params [:body :text] ))
  (println (get-in params [:body :text] ))
  (println (get-in params [:body "text"] ))
  (let [text (get-in params [:body "text"] )]
    (POST end-point
          {:handler #(-> % print)
           :params  (assoc outgoing-message :text text)
           :format  (json-request-format)})
    )
  "okay")