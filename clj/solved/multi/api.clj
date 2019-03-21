(ns multi.api)

(defmulti valid-id? :type)

; later
(defmulti valid-id? (fn [id]
                      [(:country id) (:type id)]))

