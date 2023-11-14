(ns maze.core
  (:require [clojure.edn :as edn]
            [maze.graph :as graph]
            [maze.display :as display]))

(defn -main
  ([] (println "Uso: <Largura> <Altura>"))
  ([w h] 
    (let [w (edn/read-string w)
          h (edn/read-string h)]
    (display/show-maze (graph/create-kruskal w h)))))
