(ns ^:figwheel-no-load reactcljs.dev
  (:require
    [reactcljs.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
