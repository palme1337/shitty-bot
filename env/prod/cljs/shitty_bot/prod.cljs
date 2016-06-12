(ns shitty-bot.prod
  (:require [shitty-bot.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
