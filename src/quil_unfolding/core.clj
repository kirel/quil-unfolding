(ns quil-unfolding.core
  (:import (de.fhpotsdam.unfolding UnfoldingMap)
           (de.fhpotsdam.unfolding.geo Location)
           (de.fhpotsdam.unfolding.providers StamenMapProvider)) 
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  ; Set color mode to HSB (HSV) instead of default RGB.
  (q/color-mode :hsb)
  ; setup function returns initial state.
  (let [lat 52.5075419 lon 13.4251364 loc (Location. lat lon)]
    {
     :lat lat
     :lon lon
     :loc loc
     :map (doto (UnfoldingMap.
                  (quil.applet/current-applet)
                  (de.fhpotsdam.unfolding.providers.StamenMapProvider$TonerBackground.))
            (.zoomToLevel 10)
            (.panTo loc))
     }))

(defn update-state [state] state)

(defn draw-state [state] (.draw (state :map)))

(q/defsketch quil-unfolding
  :title "Map"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  :renderer :opengl
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])
