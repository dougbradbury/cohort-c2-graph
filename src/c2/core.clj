(ns c2.core
  (:require [c2.links :as links]
            [edgewise.core :as edgewise]
            [edgewise.tgf :as converter]))
(use 'clojure.java.io)

(def f (clojure.java.io/file "data"))
(def fs (file-seq f))

(defn extract-links
  (with-open [output (clojure.java.io/writer "out/simple.txt" :append true)]
    (doseq [file fs]
      (if-not (.isDirectory file)
        (->> (slurp file)
          links/internal
          (map #(str (.getName file) " " % ))
          (clojure.string/join "\\\\n")
          (.write output))))))

(defn graph-it [g line]
  (let [[src target] (clojure.string/split line #" ")]
    (edgewise/add-edge g src target)))

(defn build-graph
  (with-open [rdr (reader "out/simple.txt")]
    (converter/->tgf (reduce graph-it (edgewise/empty-graph) (line-seq rdr)) "out/graph.tgf")))

(defn -main
  "graph the c2 wiki"
  [& args]
  (extract-links)
  (build-graph))
