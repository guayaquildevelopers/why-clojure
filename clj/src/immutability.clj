(ns immutability
  (:require [clojure.pprint :refer [pprint]]))

(defn enroll
  [student course]
  (->> (assoc course :started-at (java.util.Date.))
       (update student :courses conj)))

(defn enroll
  [student course]
  (let [enrolled-at (new java.util.Date)
        c (assoc course :started-at enrolled-at)
        courses (conj (:courses student) c)]
    (assoc student :courses courses)))

(defn student
  [sid name]
  {:courses []
   :id sid
   :name name})

(defn save-student [student]
  (println "Saving student...")
  (pprint student))

(defn save-course-stats
  [course]
  (println "Updating course " course)
  (println "Updating stats.."))

(defn get-student-by-id
  [sid]
  (student sid "Marie Curie"))

(defn get-course-by-code
  [code]
  (let [courses [{:name "Math"
                  :code "ma-101"}
                 {:name "Art"
                  :code "ar-101"}
                 {:name "History"
                  :code "hi-101"}]]
    (first (filter #(= (:code %) code) courses))))

(defn enroll-in-course
  [student-id course-code]
  (let [course (get-course-by-code course-code)
        st (-> (get-student-by-id student-id)
               (enroll course)
               (save-student))]
    (save-course-stats course)))

(defn -main
  [& args]
  (enroll-in-course "1029384756" "ma-101"))
