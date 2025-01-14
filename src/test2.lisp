;; Define a recursive function to calculate Fibonacci numbers
(defun fibonacci (n)
  "Calculates the nth Fibonacci number recursively."
  (if (<= n 1)
      n
      (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

;; Define a function to calculate the sum of a list using a loop
(defun sum-list (lst)
  "Calculates the sum of elements in a list."
  (let ((sum 0))
    (loop for elem in lst
          do (setq sum (+ sum elem)))
    sum))

;; Define a lambda function for squaring a number
(defparameter square (lambda (x) (* x x)))

;; Use a lambda function with APPLY
(defun apply-square (numbers)
  "Applies the square lambda to a list of numbers."
  (apply #'square numbers))

;; Define a function to check if a number is even
(defun is-even (n)
  "Checks if a number is even."
  (if (= (% n 2) 0)
      t
      nil))

;; Define a conditional function to classify a number
(defun classify-number (n)
  "Classifies a number as positive, negative, or zero."
  (cond
    ((> n 0) "Positive")
    ((< n 0) "Negative")
    (t "Zero")))

;; Main function to demonstrate the features
(defun main ()
  "Demonstrates various features."
  (let ((nums '(1 2 3 4 5)))
    ;; Print Fibonacci of 5
    (format t "Fibonacci of 5: ~a~%" (fibonacci 5))
    ;; Print sum of the list
    (format t "Sum of the list: ~a~%" (sum-list nums))
    ;; Apply square to each element
    (format t "Squared numbers: ~a~%" (mapcar square nums))
    ;; Check if 4 is even
    (format t "Is 4 even? ~a~%" (is-even 4))
    ;; Classify numbers
    (format t "Classify -2: ~a~%" (classify-number -2))
    (format t "Classify 0: ~a~%" (classify-number 0))
    (format t "Classify 7: ~a~%" (classify-number 7))))
