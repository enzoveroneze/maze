(ns maze.display)

(defn show-maze [g]
  (let [w (:width g)
        h (:height g)
        edges (:edges g)
        has-right? (fn [x y] (some #(= [[x y] [(inc x) y]] %) edges))
        has-below? (fn [x y] (some #(= [[x y] [x (inc y)]] %) edges))]

  (print "┏")
  (print (apply str (repeat  (dec w) "━━━━┳")))
  (println "━━━━┓")

  (dotimes [y (dec h)]
    (print "┃")
    (dotimes [x (dec w)]
      (print (if (has-right? x y) "    ┃" "     ")))
    (println "    ┃")

    (print "┣")
    (dotimes [x (dec w)]
      (print (if (has-below? x y) "━━━━╋" "    ╋")))
    (println (if (has-below? (dec w) y) "━━━━┫" "    ┫")))

  (print "┃")
  (dotimes [x (dec w)]
    (print (if (has-right? x (dec h)) "    ┃" "     ")))
  (println "    ┃")

  (print "┗")
  (print (apply str (repeat  (dec w) "━━━━┻")))
  (println "━━━━┛")))
