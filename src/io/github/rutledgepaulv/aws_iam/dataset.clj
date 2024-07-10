(ns io.github.rutledgepaulv.aws-iam.dataset
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]))


(defn read-json [resource]
  (delay (with-open [reader (io/reader (io/resource resource))]
           (json/read reader))))

(defonce categories
  (read-json "tags.json"))

(defonce iam-definition
  (read-json "iam_definition.json"))

(defonce actions
  (delay
    (->> (for [{:strs [prefix privileges]} (force iam-definition)
               {:strs [privilege]} privileges]
           (str prefix ":" privilege))
         (into (sorted-set)))))

(defonce resource-arn-patterns
  (delay
    (->> (force iam-definition)
         (mapcat #(get % "resources"))
         (map #(get % "arn"))
         (into (sorted-set)))))

(defonce api-categories
  (update-vals (get (force categories) "api") set))

(defonce resource-exposure
  (delay (get (force api-categories) "ResourceExposure")))

(defonce privilege-escalation
  (delay (get (force api-categories) "PrivEsc")))

(defonce data-access
  (delay (get (force api-categories) "DataAccess")))

(defonce credential-exposure
  (delay (get (force api-categories) "CredentialExposure")))

