;fast exponentiation
(define (fast-exp x n)
  (cond ((= n 0) 1)
        ((even? n) (square (fast-exp x (/ n 2))))
        (else (* x (fast-exp x (- n 1))))))

        
(define (even? n)
  (if (= (remainder n 2) 0)
    true
    false))

(fast-exp 2 10)

;log(n) fibonacci algo
(define (fib n)
  (fib-iter 1 0 0 1 n))
(define (fib-iter a b p q count)
  (cond ((= count 0) b)
        ((even? count)
         (fib-iter a
                   b
                   (+ (square p) (square q))  ; compute p'
                   (+ (square q) (* p q) (* p q))  ; compute q'
                   (/ count 2)))
        (else (fib-iter (+ (* b q) (* a q) (* a p))
                        (+ (* b p) (* a q))
                        p
                        q
                        (- count 1)))))

(fib 10)

