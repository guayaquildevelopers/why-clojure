(ns multi
  (:require [multi.api :as api]
            [multi.ec]))
            ; [multi.pe]))

(defn prompt
  [msg]
  (do
    (print msg)
    (flush)
    (read-line)))

(defn -main
  [& args]
  (println "Valida tu número de identificación")
  (let [number (prompt "Número: ")
        type-in (prompt "Tipo (cédula, RUC): ")
        type (case type-in
              "cedula" :personal-id
              "RUC"    :tax-id)]
    (if (api/valid-id? {:number number
                        :type type})
      (println "\n¡Válido! :)")
      (println "\n¡No válido! :("))))

(defn -main
  [& args]
  (println "Valida tu número de identificación")
  (let [country (prompt "País: ")
        number (prompt "Número: ")
        type-in (prompt "Tipo (cédula, RUC): ")
        type (case type-in
              "cedula" :personal-id
              "RUC"    :tax-id)]
    (if (api/valid-id? {:country (keyword country)
                        :number number
                        :type type})
      (println "\n¡Válido! :)")
      (println "\n¡No válido! :("))))
