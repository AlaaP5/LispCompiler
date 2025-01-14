(print (- 2 3))

(defun apply-lambda (func x y)
  "Applies a lambda function to two arguments."
  (funcall func x y))

(defun factorial (n)
  "Calculates the factorial of a number recursively."
  (if (<= n 1)
      1
      (* n (factorial (- n 1)))))