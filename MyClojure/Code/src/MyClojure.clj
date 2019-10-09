(ns MyClojure)
(gen-class
	:name MyClojure
	:main false
	:extends leikr.Engine)

	(def x (make-array Integer/TYPE 10))
	(def y (make-array Integer/TYPE 10))
	
	(def dx (make-array Integer/TYPE 10))
	(def dy (make-array Integer/TYPE 10))
	
	(def c (make-array Integer/TYPE 10))
	
	(defn -create [this]
		(dotimes [i 10]
			(aset x i (rand-int 230))
			(aset y i (rand-int 150))
			(aset dx i 1)
			(aset dy i 1)
			(aset c i (rand-int 32))))
	
	(defn -update [this delta]
		(dotimes [i 10]
			(if (> (aget x i) 230) (aset dx i -1) nil)
			(if (< (aget x i) 0) (aset dx i 1) nil)
			(aset x i (+ (aget x i) (aget dx i)))
			
			(if (> (aget y i) 150) (aset dy i -1) nil)
			(if (< (aget y i) 0) (aset dy i 1) nil)
			(aset y i (+ (aget y i) (aget dy i)))))
 
	(defn -render [this]
		(dotimes [i 10]
			(.setColor this (aget c i))
			(.fillRect this (bigdec (aget x i)) (bigdec (aget y i)) (bigdec 10) (bigdec 10) )))
		
