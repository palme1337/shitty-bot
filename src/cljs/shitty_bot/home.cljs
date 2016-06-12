(ns shitty-bot.home
  (:require
    [reagent.core :as r :refer [atom]]
    [ajax.core :refer [POST json-request-format]]))

(defonce state (r/atom {:text "Nothing to say but hey."}))

(defn send-that-shit [e]
  (.preventDefault e)
  (POST "/sendMessage"
        {:handler #(-> % print)
         :params  @state}))

(defn update-state [message]
  (swap! state assoc :text message))

(defn home-page []
  [:div [:h2 "Welcome to shitty-bot"]
   [:form
    [:input {:on-change #(update-state (-> % .-target .-value))}]
    [:button {:on-click send-that-shit} "Send that shit"]
    ]
   [:div (:text @state)]])
