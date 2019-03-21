(ns functional)

(defn calculate-subtotals
  [{:keys [quantity price discount] :as item}]
  (assoc item :subtotal (* quantity price (- 1 discount))))

(defn stock-availability
  [{:keys [quantity product-id] :as item}]
  (assoc :in-stock (>= quantity (:quantity (get-stock product-id)))))

(defn prepare-for-checkout
  [line-items]
  (map (comp calculate-subtotals
             check-stock)
       line-items))