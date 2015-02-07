(ns org.audio.testd.main
  (:require [neko.activity :refer [defactivity set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.threading :refer [on-ui]]
            [neko.action-bar :refer :all]
            [neko.ui :refer :all]
            [neko.notify :refer [toast]]
            ))

;; https://gist.github.com/alexander-yakushev/2907442

;(def stuff-ui-tree (comp vec concat))

(defn start-recording
  []
  (toast "Started Recording"))

(defactivity org.audio.testd.MainActivity
             :key :main
             :def foobar
             :on-create
             (fn [this bundle]
               (on-ui
                 (set-content-view!
                   foobar
                   (make-ui
                     [:linear-layout {:orientation :vertical}
                      [:button {:text     "Record"
                                :on-click (fn [_] (start-recording))}]])))))

(defactivity org.audio.testd.ActionBarActivity
             :key :main
             :def a
             :on-create
             (fn [this bundle]
               (on-ui
                 (setup-action-bar
                   a {:title           "Testd Clojure"
                      :icon            (neko.resource/get-drawable :android/btn-star-big-on)
                      :display-options [:show-home :show-title :home-as-up]
                      :subtitle        "Lein Droid"
                      :navigation-mode :tabs
                      :tabs            [
                                        [:tab {:text         "Record"
                                               :tab-listener (tab-listener
                                                               :on-tab-selected (fn [tab ft]
                                                                                  (toast "record")))}]
                                        [:tab {:text         "Compare"
                                               :tab-listener (tab-listener
                                                               :on-tab-selected (fn [tab ft]
                                                                                  (toast "compare")))}]]}))))
