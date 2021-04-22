;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit ctrl+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns icy-meadow
  (:require [gorilla-plot.core :as plot]
            [etaoin.api :as eapi]
            [etaoin.keys :as k])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; Let's test first Etaoin
;; **

;; @@
(def driver (eapi/firefox))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;icy-meadow/driver</span>","value":"#'icy-meadow/driver"}
;; <=

;; @@
(eapi/go driver "https://en.wikipedia.org/")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:value</span>","value":":value"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:value nil]"}],"value":"{:value nil}"}
;; <=

;; @@

;; @@
