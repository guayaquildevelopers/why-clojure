(ns exporter)

(defmulti export
  "Export contacts to a file"
  (fn [contacts file-params]
    (:format file-params)))

(defmethod export :default
  [contacts file-params]
  (throw (ex-info "Format not supported" {:file-params file-params})))
