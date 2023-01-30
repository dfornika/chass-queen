(ns chass-queen.core
  (:require [reagent.dom]
            [chass-queen.router :as router]
            [chass-queen.views :as views]
            [chass-queen.db :refer [db]]))

(defn ^:export init
  []
  (router/start! db)
  (reagent.dom/render [views/root {:db db :router router/router}]
    (.getElementById js/document "app")))

