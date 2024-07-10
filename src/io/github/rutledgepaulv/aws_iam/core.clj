(ns io.github.rutledgepaulv.aws-iam.core)

(defn services []
  )

(defn actions [service]
  )

(defn read? [action]
  )

(defn write? [action]
  )

(defn delete? [action]
  )

(defn list? [action]
  )

(defn credential-exposure? [action]
  )

(defn privilege-escalation? [action]
  )

(defn data-access? [action]
  )

(defn resource-exposure? [action]
  )

(defn decompress [policy]
  )

(defn compress [policy]
  )

(defn union [& policies]
  )

(defn intersect [& policies]
  )

(defn difference [& policies]
  )

(defn complement [policy]
  )

(defn invert [policy]
  )

(defn authorized? [system-control-policies principal-policies resource-policies request]
  )

(defn explain [system-control-policies principal-policies resource-policies request]
  )
