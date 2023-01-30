(ns chass-queen.views
  (:require [chass-queen.db :refer [db]]
            [clojure.string :as str]
            [reitit.core :as reitit]))

(defn root [{:keys [db router]}]
  (let [route (:route-match @db)]
    (if (some? route)
      (when-let [view (get-in route [:data :view])]
        [view])
      (-> router reitit/options :default-view))))

(def square-palette {:light "#869dba"
                     :dark "#354f70"})

(def piece-id->char {:empty          ""
                     :black-rook-a   "♜"
                     :black-knight-b "♞"
                     :black-bishop-c "♝"
                     :black-queen    "♝"
                     :black-king     "♚"
                     :black-bishop-f "♝"
                     :black-knight-g "♞"
                     :black-rook-h   "♜"
                     :black-pawn-a   "♟"
                     :black-pawn-b   "♟"
                     :black-pawn-c   "♟"
                     :black-pawn-d   "♟"
                     :black-pawn-e   "♟"
                     :black-pawn-f   "♟"
                     :black-pawn-g   "♟"
                     :black-pawn-h   "♟"
                     :white-rook-a   "♖"
                     :white-knight-b "♘"
                     :white-bishop-c "♗"
                     :white-queen    "♕"
                     :white-king     "♔"
                     :white-bishop-f "♗"
                     :white-knight-g "♘"
                     :white-rook-h   "♖"
                     :white-pawn-a   "♙"
                     :white-pawn-b   "♙"
                     :white-pawn-c   "♙"
                     :white-pawn-d   "♙"
                     :white-pawn-e   "♙"
                     :white-pawn-f   "♙"
                     :white-pawn-g   "♙"
                     :white-pawn-h   "♙"})

                     

(defn square
  [id color]
  (let [square-color (get square-palette color)
        piece "♖"]
    [:div {:id id
           :style {:float "left"
                   :width "80px"
                   :height "80px"
                   :font-size "50px"
                   :text-align "center"
                   :vertical-align "middle"
                   :display "table-cell"
                   :background-color square-color}} piece]))

(defn board
  ""
  []
  [:div {:style {:margin "auto"
                 :width "640px"
                 :height "640px"
                 :border "2px solid #333"}}

   ;; TODO: abstract this
   (square :a8 :light)
   (square :b8 :dark)
   (square :c8 :light)
   (square :d8 :dark)
   (square :e8 :light)
   (square :f8 :dark)
   (square :g8 :light)
   (square :h8 :dark)
   
   (square :a7 :dark)
   (square :b7 :light)
   (square :c7 :dark)
   (square :d7 :light)
   (square :e7 :dark)
   (square :f7 :light)
   (square :g7 :dark)
   (square :h7 :light)

   (square :a6 :light)
   (square :b6 :dark)
   (square :c6 :light)
   (square :d6 :dark)
   (square :e6 :light)
   (square :f6 :dark)
   (square :g6 :light)
   (square :h6 :dark)

   (square :a5 :dark)
   (square :b5 :light)
   (square :c5 :dark)
   (square :d5 :light)
   (square :e5 :dark)
   (square :f5 :light)
   (square :g5 :dark)
   (square :h5 :light)

   (square :a4 :light)
   (square :b4 :dark)
   (square :c4 :light)
   (square :d4 :dark)
   (square :e4 :light)
   (square :f4 :dark)
   (square :g4 :light)
   (square :h4 :dark)

   (square :a3 :dark)
   (square :b3 :light)
   (square :c3 :dark)
   (square :d3 :light)
   (square :e3 :dark)
   (square :f3 :light)
   (square :g3 :dark)
   (square :h3 :light)

   (square :a2 :light)
   (square :b2 :dark)
   (square :c2 :light)
   (square :d2 :dark)
   (square :e2 :light)
   (square :f2 :dark)
   (square :g2 :light)
   (square :h2 :dark)

   (square :a1 :dark)
   (square :b1 :light)
   (square :c1 :dark)
   (square :d1 :light)
   (square :e1 :dark)
   (square :f1 :light)
   (square :g1 :dark)
   (square :h1 :light)

   ])
