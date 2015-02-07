(ns org.audio.testd.main
  (:require [neko.activity :refer [defactivity set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.threading :refer [on-ui]]
            [neko.action-bar :refer :all]
            [neko.notify :refer [toast]]
            ))

(defactivity org.audio.testd.MainActivity
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
                                        [:tab {:text         "Alpha"
                                               :tab-listener (tab-listener
                                                               :on-tab-selected (fn [tab ft]
                                                                                  (toast "alpha")))}]
                                        [:tab {:text         "Beta"
                                               :tab-listener (tab-listener
                                                               :on-tab-selected (fn [tab ft]
                                                                                  (toast "beta")))}]]}))))
