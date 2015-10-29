Common Lisp
https://www.youtube.com/watch?v=ymSq4wHrqyU

;;;; Lisp stands for List Processing, not
;;;; Lots of Irritating Superflous Parentheses
;;;; Lisps great strength is that you can use data to generate code

;;;; Describe program comment/At the top of source files
;;; basic comment 
;; 	indented along with code comment
; inline comments 

#||
Multiline comment
||#


;;; === Small program to ask your name and greet you ===

;;; output text on screen
(format t "Hello world ~%") 	; "~%" == "\n"
(print "What's your name?!")

;;; Varaibles
;;; NOT CASE SENSETIVE

;;; define variable
;;; global variables usually surounded by *.
(defvar *name* (read))  ; create variable name and store input from terminal

;;; define function hello-you with *name* as parameter
(defun hello-you (*name*)
	;; print out greeting
	;; ~a : Shows the value
	;; ~s : Shows quotes around the value
	;; ~10a : Adds 10 spaces for the value with extra space to the right
	;; ~10@a : Adds 10 spaces for the value with extra space to the left
	(format t "Hello ~a! ~%" *name*)	; "~a" - placeholder
)

;;; Set default display mode
;;; :upcase
;;; :downcase
(setq *print-case* :capitalize)

;;; call function hello-you with *name* parameter
(hello-you *name*)

;;; === end of this progrem ===




;;; Forms
;;; A form is a list with a command function name at the beginning
;;; Everything that follows the command is sent as parameters to the function
;;; [+] [5] [4] [nil]
(+ 5 4) ; = 9

(+ 5 (- 6 2)) ; = 9

;;; Variables

;;; define variable 
(defvar *number* 0)
;;; change variable value
(setf *number* 6) 

;;; Formats
(format t "Number with commas ~:d" 10000000)
(format t "PI to 5 characters ~5f" 3.141593)
(format t "PI to 4 decimals ~,4f" 3.141593)
(format t "10 Percent ~,,2f" .10)
(format t "10 Dollars ~$ ~%" 10)
