(ns multi.api)

(defmulti valid-id? (fn [id] [(:country id) (:type id)]))
