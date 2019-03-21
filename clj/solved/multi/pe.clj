(ns multi.pe
  (:require [multi.api :refer [valid-id?]]))

(defmethod valid-id? :personal-id
  [id]
  (= (count (:number id)) 10))

(defmethod valid-id? :tax-id
  [id]
  (= (count (:number id)) 13))


; later
(defmethod valid-id? [:pe :personal-id]
  [id]
  (= (count (:number id)) 11))

(defmethod valid-id? [:pe :tax-id]
  [id]
  (= (count (:number id)) 14))
