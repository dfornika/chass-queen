(ns chass-queen.router
  (:require [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [chass-queen.views :as views]))

(def routes
  [["/" {:name ::root
         :view #'views/board}]])

(def router
  (rf/router routes {:default-view #'views/board}))

(defn on-navigate
  ""
  [db new-match history] 
  (swap! db (fn [old-db] 
              (when new-match
                (assoc old-db :route-match
                       (assoc new-match :controllers
                              (rfc/apply-controllers (get-in old-db [:route-match :controllers]) new-match)))))))


(defn start!
  ""
  [db]
  (rfe/start! router (partial on-navigate db) {:use-fragment false}))
