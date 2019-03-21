(ns reactcljs.prod
  (:require [reactcljs.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
