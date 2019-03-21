(ns contacts
  (:require [exporter]
            [exporter.csv]
            [exporter.json]))

(defn prompt
  [msg]
  (do
    (print msg)
    (flush)
    (read-line)))

(def my-contacts
  [{:first-name "Homero"
    :last-name "Simpson"
    :hobbies ["tomar cerveza" "estrangular a Bart"]}
   {:first-name "Oliver"
    :last-name "Atom"
    :hobbies ["fúbol" "trapecista"]}
   {:first-name "Shaggy"
    :last-name "Rogers"
    :hobbies ["leer novelas" "correr"]}])

(defn -main
  [& args]
  (println "Exportando contactos")
  (let [fmt (prompt "Formato (csv, json):")]
    (exporter/export my-contacts
                     {:format fmt
                      :path (format "/Users/juanantonio/Downloads/contacts.%s"
                                    fmt)})
    (println "! Process complete")))
