(print "What's your name?!")
(defvar *name* (read))  ; create variable name and store input from terminal

(defun hello-you (*name*)
	(format t "Hello ~a! ~%" *name*)
)

(setq *print-case* :capitalize)

(hello-you *name*)