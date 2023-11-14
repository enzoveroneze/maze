(ns maze.graph
  (:require [clojure.set]))

(defn all-edges [width height]
  (concat
    (for [x (range (dec width)) y (range height)]
      [[x y] [(inc x) y]])
    (for [x (range width) y (range (dec height))]
      [[x y] [x (inc y)]])))


(defn init-forests [width height]
  (reduce
    (fn [acc e] (conj acc {:width width :height height :nodes #{e} :edges []}))
    #{}
    (for [x (range width) y (range height)] [x y])))


(defn find-forest [forests pos]
  (first
    (filter
      (fn [f] (contains? (:nodes f) pos))
      forests)))


(defn merge-forests [f-1 f-2 edge]
  (let [{ns-1 :nodes es-1 :edges} f-1
        {ns-2 :nodes es-2 :edges} f-2]
    {:width (or (:width f-1) (:width f-2))
     :height (or (:height f-1) (:height f-2))
     :nodes (clojure.set/union ns-1 ns-2)
     :edges (conj (into es-1 es-2) edge)}))

(defn create-kruskal
  ([width height] (create-kruskal width height (init-forests width height)))
  ([width height forests]
   (loop [forests forests
          edges (shuffle (all-edges width height))]
     (if (> (count forests) 1)
       (let [[pos-1 pos-2 :as edge] (first edges)
             f-1 (find-forest forests pos-1)
             f-2 (find-forest forests pos-2)]
         (recur
           (if (= f-1 f-2)
             forests
             (let [merged (merge-forests f-1 f-2 edge)]
               (-> forests
                   (disj f-1 f-2)
                   (conj merged))))
           (rest edges)))
       (first forests)))))
