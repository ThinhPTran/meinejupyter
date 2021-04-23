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
(def hpgdata 
  (->> (eapi/query-all driver [{:tag :table :fn/has-class "stock"}{:tag :tbody}{:tag :tr}])
       (rest)
       ;(take 2)
       (map (fn [in] 
              (->> 
                (eapi/children driver in {:tag :td})
                (map #(eapi/get-element-text-el driver %))
               )))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;icy-meadow/hpgdata</span>","value":"#'icy-meadow/hpgdata"}
;; <=

;; @@
(take 5 hpgdata)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;#1&quot;</span>","value":"\"#1\""},{"type":"html","content":"<span class='clj-string'>&quot;22-04-2021&quot;</span>","value":"\"22-04-2021\""},{"type":"html","content":"<span class='clj-string'>&quot;57.20&quot;</span>","value":"\"57.20\""},{"type":"html","content":"<span class='clj-string'>&quot;-2.20&quot;</span>","value":"\"-2.20\""},{"type":"html","content":"<span class='clj-string'>&quot;-3.85%&quot;</span>","value":"\"-3.85%\""},{"type":"html","content":"<span class='clj-string'>&quot;55&quot;</span>","value":"\"55\""},{"type":"html","content":"<span class='clj-string'>&quot;33,049,800&quot;</span>","value":"\"33,049,800\""},{"type":"html","content":"<span class='clj-string'>&quot;56.50&quot;</span>","value":"\"56.50\""},{"type":"html","content":"<span class='clj-string'>&quot;57.90&quot;</span>","value":"\"57.90\""},{"type":"html","content":"<span class='clj-string'>&quot;55&quot;</span>","value":"\"55\""},{"type":"html","content":"<span class='clj-string'>&quot;40,000&quot;</span>","value":"\"40,000\""},{"type":"html","content":"<span class='clj-string'>&quot;1,571,200&quot;</span>","value":"\"1,571,200\""},{"type":"html","content":"<span class='clj-string'>&quot;5,750,300&quot;</span>","value":"\"5,750,300\""}],"value":"(\"#1\" \"22-04-2021\" \"57.20\" \"-2.20\" \"-3.85%\" \"55\" \"33,049,800\" \"56.50\" \"57.90\" \"55\" \"40,000\" \"1,571,200\" \"5,750,300\")"},{"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;#2&quot;</span>","value":"\"#2\""},{"type":"html","content":"<span class='clj-string'>&quot;20-04-2021&quot;</span>","value":"\"20-04-2021\""},{"type":"html","content":"<span class='clj-string'>&quot;57.80&quot;</span>","value":"\"57.80\""},{"type":"html","content":"<span class='clj-string'>&quot;-0.60&quot;</span>","value":"\"-0.60\""},{"type":"html","content":"<span class='clj-string'>&quot;-1.04%&quot;</span>","value":"\"-1.04%\""},{"type":"html","content":"<span class='clj-string'>&quot;57.20&quot;</span>","value":"\"57.20\""},{"type":"html","content":"<span class='clj-string'>&quot;37,829,300&quot;</span>","value":"\"37,829,300\""},{"type":"html","content":"<span class='clj-string'>&quot;58&quot;</span>","value":"\"58\""},{"type":"html","content":"<span class='clj-string'>&quot;58.60&quot;</span>","value":"\"58.60\""},{"type":"html","content":"<span class='clj-string'>&quot;56&quot;</span>","value":"\"56\""},{"type":"html","content":"<span class='clj-string'>&quot;510,000&quot;</span>","value":"\"510,000\""},{"type":"html","content":"<span class='clj-string'>&quot;2,759,400&quot;</span>","value":"\"2,759,400\""},{"type":"html","content":"<span class='clj-string'>&quot;4,563,700&quot;</span>","value":"\"4,563,700\""}],"value":"(\"#2\" \"20-04-2021\" \"57.80\" \"-0.60\" \"-1.04%\" \"57.20\" \"37,829,300\" \"58\" \"58.60\" \"56\" \"510,000\" \"2,759,400\" \"4,563,700\")"},{"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;#3&quot;</span>","value":"\"#3\""},{"type":"html","content":"<span class='clj-string'>&quot;19-04-2021&quot;</span>","value":"\"19-04-2021\""},{"type":"html","content":"<span class='clj-string'>&quot;54.60&quot;</span>","value":"\"54.60\""},{"type":"html","content":"<span class='clj-string'>&quot;3.20&quot;</span>","value":"\"3.20\""},{"type":"html","content":"<span class='clj-string'>&quot;5.86%&quot;</span>","value":"\"5.86%\""},{"type":"html","content":"<span class='clj-string'>&quot;57.80&quot;</span>","value":"\"57.80\""},{"type":"html","content":"<span class='clj-string'>&quot;34,808,100&quot;</span>","value":"\"34,808,100\""},{"type":"html","content":"<span class='clj-string'>&quot;55.20&quot;</span>","value":"\"55.20\""},{"type":"html","content":"<span class='clj-string'>&quot;57.80&quot;</span>","value":"\"57.80\""},{"type":"html","content":"<span class='clj-string'>&quot;54.70&quot;</span>","value":"\"54.70\""},{"type":"html","content":"<span class='clj-string'>&quot;20,000&quot;</span>","value":"\"20,000\""},{"type":"html","content":"<span class='clj-string'>&quot;1,097,300&quot;</span>","value":"\"1,097,300\""},{"type":"html","content":"<span class='clj-string'>&quot;2,517,700&quot;</span>","value":"\"2,517,700\""}],"value":"(\"#3\" \"19-04-2021\" \"54.60\" \"3.20\" \"5.86%\" \"57.80\" \"34,808,100\" \"55.20\" \"57.80\" \"54.70\" \"20,000\" \"1,097,300\" \"2,517,700\")"},{"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;#4&quot;</span>","value":"\"#4\""},{"type":"html","content":"<span class='clj-string'>&quot;16-04-2021&quot;</span>","value":"\"16-04-2021\""},{"type":"html","content":"<span class='clj-string'>&quot;54.50&quot;</span>","value":"\"54.50\""},{"type":"html","content":"<span class='clj-string'>&quot;0.10&quot;</span>","value":"\"0.10\""},{"type":"html","content":"<span class='clj-string'>&quot;0.18%&quot;</span>","value":"\"0.18%\""},{"type":"html","content":"<span class='clj-string'>&quot;54.60&quot;</span>","value":"\"54.60\""},{"type":"html","content":"<span class='clj-string'>&quot;28,433,700&quot;</span>","value":"\"28,433,700\""},{"type":"html","content":"<span class='clj-string'>&quot;54.10&quot;</span>","value":"\"54.10\""},{"type":"html","content":"<span class='clj-string'>&quot;55.70&quot;</span>","value":"\"55.70\""},{"type":"html","content":"<span class='clj-string'>&quot;53.50&quot;</span>","value":"\"53.50\""},{"type":"html","content":"<span class='clj-string'>&quot;199,000&quot;</span>","value":"\"199,000\""},{"type":"html","content":"<span class='clj-string'>&quot;616,100&quot;</span>","value":"\"616,100\""},{"type":"html","content":"<span class='clj-string'>&quot;3,477,900&quot;</span>","value":"\"3,477,900\""}],"value":"(\"#4\" \"16-04-2021\" \"54.50\" \"0.10\" \"0.18%\" \"54.60\" \"28,433,700\" \"54.10\" \"55.70\" \"53.50\" \"199,000\" \"616,100\" \"3,477,900\")"},{"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;#5&quot;</span>","value":"\"#5\""},{"type":"html","content":"<span class='clj-string'>&quot;15-04-2021&quot;</span>","value":"\"15-04-2021\""},{"type":"html","content":"<span class='clj-string'>&quot;53&quot;</span>","value":"\"53\""},{"type":"html","content":"<span class='clj-string'>&quot;1.50&quot;</span>","value":"\"1.50\""},{"type":"html","content":"<span class='clj-string'>&quot;2.83%&quot;</span>","value":"\"2.83%\""},{"type":"html","content":"<span class='clj-string'>&quot;54.50&quot;</span>","value":"\"54.50\""},{"type":"html","content":"<span class='clj-string'>&quot;32,078,100&quot;</span>","value":"\"32,078,100\""},{"type":"html","content":"<span class='clj-string'>&quot;53.50&quot;</span>","value":"\"53.50\""},{"type":"html","content":"<span class='clj-string'>&quot;54.70&quot;</span>","value":"\"54.70\""},{"type":"html","content":"<span class='clj-string'>&quot;52.50&quot;</span>","value":"\"52.50\""},{"type":"html","content":"<span class='clj-string'>&quot;0&quot;</span>","value":"\"0\""},{"type":"html","content":"<span class='clj-string'>&quot;1,713,800&quot;</span>","value":"\"1,713,800\""},{"type":"html","content":"<span class='clj-string'>&quot;2,502,700&quot;</span>","value":"\"2,502,700\""}],"value":"(\"#5\" \"15-04-2021\" \"53\" \"1.50\" \"2.83%\" \"54.50\" \"32,078,100\" \"53.50\" \"54.70\" \"52.50\" \"0\" \"1,713,800\" \"2,502,700\")"}],"value":"((\"#1\" \"22-04-2021\" \"57.20\" \"-2.20\" \"-3.85%\" \"55\" \"33,049,800\" \"56.50\" \"57.90\" \"55\" \"40,000\" \"1,571,200\" \"5,750,300\") (\"#2\" \"20-04-2021\" \"57.80\" \"-0.60\" \"-1.04%\" \"57.20\" \"37,829,300\" \"58\" \"58.60\" \"56\" \"510,000\" \"2,759,400\" \"4,563,700\") (\"#3\" \"19-04-2021\" \"54.60\" \"3.20\" \"5.86%\" \"57.80\" \"34,808,100\" \"55.20\" \"57.80\" \"54.70\" \"20,000\" \"1,097,300\" \"2,517,700\") (\"#4\" \"16-04-2021\" \"54.50\" \"0.10\" \"0.18%\" \"54.60\" \"28,433,700\" \"54.10\" \"55.70\" \"53.50\" \"199,000\" \"616,100\" \"3,477,900\") (\"#5\" \"15-04-2021\" \"53\" \"1.50\" \"2.83%\" \"54.50\" \"32,078,100\" \"53.50\" \"54.70\" \"52.50\" \"0\" \"1,713,800\" \"2,502,700\"))"}
;; <=

;; @@

;; @@
