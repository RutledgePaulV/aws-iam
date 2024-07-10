(ns io.github.rutledgepaulv.aws-iam.categorization
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]))


(defonce categories
  (delay (with-open [reader (io/reader (io/resource "tags.json"))]
           (json/read reader))))

(defonce managed-policies
  (delay (with-open [reader (io/reader (io/resource "managed_policies.json"))]
           )))

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

