(ns contact-exporter-app
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [clojure.string :as string]))

(defmulti export
  "Export contacts to a file"
  (fn [contacts file-params]
    (:format file-params)))

(defmethod export :default
  [contacts file-params]
  (throw (ex-info "Format not supported" {:file-params file-params})))

(defmethod export "csv"
  [contacts file]
  (println "Exporting to CSV..."))

(defmethod export "json"
  [contacts file]
  (println "Exporting to JSON..."))

(defn -main
  [& args]
  (exporter/export []
                   {:format fmt
                    :path (format "/Users/juanantonio/Downloads/contacts.%s"
                                  fmt)})
  (println "! Process complete"))



(def csv-header
  ["First name" "Last name" "Hobbies"])

(defn contact-info
  [{:keys [first-name last-name hobbies] :as contact}]
  [first-name last-name (string/join ", " hobbies)]))

;; main

(defn prompt
  [msg]
  (do
    (print msg)
    (flush)
    (read-line)))

(defn -main
  [& args]
  (println "Exportando contactos")
  (let [fmt (prompt "Formato (csv, json):")
        contacts [{:first-name "Homero"
                   :last-name "Simpson"
                   :hobbies ["tomar cerveza" "estrangular a Bart"]
                   {:first-name "Oliver"
                    :last-name "Atom"
                    :hobbies ["fúbol" "trapecista"]}
                   {:first-name "Shaggy"
                    :last-name "Rogers"
                    :hobbies ["leer novelas" "correr"]}}]]
    (exporter/export contacts
                     {:format fmt
                      :path (format "/Users/juanantonio/Downloads/contacts.%s"
                                    fmt)})
    (println "! Process complete")))
