(ns c2.links)

(defn internal [page-string]
 (map #(nth % 1)
    (re-seq #".*<a href=\"wiki\?(\w*)\">.*"
                page-string)))

