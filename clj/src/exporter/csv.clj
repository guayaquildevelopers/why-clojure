(ns exporter.csv
  (:require [exporter :refer [export]]
            [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(def header
  ["First name" "Last name" "Hobbies"])

(defn contact-info
  [{:keys [first-name last-name hobbies] :as contact}]
  [first-name last-name (string/join ", " hobbies)])

(defmethod export "csv"
  [contacts file]
  (with-open [writer (io/writer (:path file))]
    (csv/write-csv writer
                   (concat [header]
                           (mapv contact-info contacts)))))
