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
            [etaoin.keys :as k]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; Let's test first Etaoin
;; **

;; @@
(def driver (eapi/firefox))
(eapi/go driver "https://en.wikipedia.org/")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:value</span>","value":":value"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:value nil]"}],"value":"{:value nil}"}
;; <=

;; **
;;; Get data from Hoa Phat
;; **

;; @@
(def driver (eapi/firefox))
(eapi/go driver "https://www.cophieu68.vn/historyprice.php?id=hpg")
(eapi/wait-visible driver {:id :advancedButton})
(eapi/click driver {:id :advancedButton})
(eapi/wait-visible driver {:id :exceptionDialogButton})
(eapi/click driver {:id :exceptionDialogButton})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:value</span>","value":":value"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:value nil]"}],"value":"{:value nil}"}
;; <=

;; **
;;; Get headers
;; **

;; @@
(->> (eapi/query-all driver [{:tag :table :fn/has-class "stock"}{:tag :tbody}{:tag :tr :fn/has-class "tr_header"}{:tag :td}])
     (map #(eapi/get-element-inner-html-el driver %)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;STT&quot;</span>","value":"\"STT\""},{"type":"html","content":"<span class='clj-string'>&quot;Ngày&quot;</span>","value":"\"Ngày\""},{"type":"html","content":"<span class='clj-string'>&quot;Giá Tham Chiếu&quot;</span>","value":"\"Giá Tham Chiếu\""},{"type":"html","content":"<span class='clj-string'>&quot;+/- (*)&quot;</span>","value":"\"+/- (*)\""},{"type":"html","content":"<span class='clj-string'>&quot; % (*)&quot;</span>","value":"\" % (*)\""},{"type":"html","content":"<span class='clj-string'>&quot;Đóng Cửa (*)&quot;</span>","value":"\"Đóng Cửa (*)\""},{"type":"html","content":"<span class='clj-string'>&quot;Khối Lượng&quot;</span>","value":"\"Khối Lượng\""},{"type":"html","content":"<span class='clj-string'>&quot;Mở Cửa (*)&quot;</span>","value":"\"Mở Cửa (*)\""},{"type":"html","content":"<span class='clj-string'>&quot;Cao Nhất(*)&quot;</span>","value":"\"Cao Nhất(*)\""},{"type":"html","content":"<span class='clj-string'>&quot;Thấp Nhất(*)&quot;</span>","value":"\"Thấp Nhất(*)\""},{"type":"html","content":"<span class='clj-string'>&quot;Giao Dịch Thỏa Thuận&quot;</span>","value":"\"Giao Dịch Thỏa Thuận\""},{"type":"html","content":"<span class='clj-string'>&quot;Nước Ngoài Mua&quot;</span>","value":"\"Nước Ngoài Mua\""},{"type":"html","content":"<span class='clj-string'>&quot;Nước Ngoài Bán&quot;</span>","value":"\"Nước Ngoài Bán\""}],"value":"(\"STT\" \"Ngày\" \"Giá Tham Chiếu\" \"+/- (*)\" \" % (*)\" \"Đóng Cửa (*)\" \"Khối Lượng\" \"Mở Cửa (*)\" \"Cao Nhất(*)\" \"Thấp Nhất(*)\" \"Giao Dịch Thỏa Thuận\" \"Nước Ngoài Mua\" \"Nước Ngoài Bán\")"}
;; <=

;; @@
(->> (eapi/query-all driver [{:tag :table :fn/has-class "stock"}{:tag :tbody}{:tag :tr :fn/has-class "tr_header"}{:tag :td}])
     (map #(eapi/get-element-attr-el driver % "title")))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;So thu tu&quot;</span>","value":"\"So thu tu\""},{"type":"html","content":"<span class='clj-string'>&quot;Ngày&quot;</span>","value":"\"Ngày\""},{"type":"html","content":"<span class='clj-string'>&quot;Giá Tham Chiếu&quot;</span>","value":"\"Giá Tham Chiếu\""},{"type":"html","content":"<span class='clj-string'>&quot;Thay Đổi&quot;</span>","value":"\"Thay Đổi\""},{"type":"html","content":"<span class='clj-string'>&quot;Thay Đổi %&quot;</span>","value":"\"Thay Đổi %\""},{"type":"html","content":"<span class='clj-string'>&quot;Đóng Cửa&quot;</span>","value":"\"Đóng Cửa\""},{"type":"html","content":"<span class='clj-string'>&quot;Khối Lượng&quot;</span>","value":"\"Khối Lượng\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;Giao Dịch Thỏa Thuận&quot;</span>","value":"\"Giao Dịch Thỏa Thuận\""},{"type":"html","content":"<span class='clj-string'>&quot;Nước Ngoài Mua&quot;</span>","value":"\"Nước Ngoài Mua\""},{"type":"html","content":"<span class='clj-string'>&quot;Nước Ngoài Bán&quot;</span>","value":"\"Nước Ngoài Bán\""}],"value":"(\"So thu tu\" \"Ngày\" \"Giá Tham Chiếu\" \"Thay Đổi\" \"Thay Đổi %\" \"Đóng Cửa\" \"Khối Lượng\" \"\" \"\" \"\" \"Giao Dịch Thỏa Thuận\" \"Nước Ngoài Mua\" \"Nước Ngoài Bán\")"}
;; <=

;; **
;;; Get rows
;; **

;; @@
(->> (eapi/query-all driver))
;; @@
