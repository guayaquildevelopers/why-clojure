(ns multi.ec
  (:require [multi.api :refer [valid-id?]]))

(defmethod valid-id? :personal-id
  [id]
  (= (count (:number id)) 10))

(defmethod valid-id? :tax-id
  [id]
  (= (count (:number id)) 13))

; later
; (defmethod valid-id? :personal-id
;   [id]
;   (= (count (:number id)) 10))
