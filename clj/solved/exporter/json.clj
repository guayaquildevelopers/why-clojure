(ns exporter.json
  (:require [exporter :refer [export]]
            [clojure.data.json :as json]
            [clojure.java.io :as io]))

(defmethod export "json"
  [contacts file]
  (with-open [writer (io/writer (:path file))]
    (spit writer (json/write-str contacts))))
