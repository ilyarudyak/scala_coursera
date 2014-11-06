;(define (pi-sum a b)
;  (if (> a b)
;      0
;      (+ (/ 1.0 (* a (+ a 2))) (pi-sum (+ a 4) b))))
;
;(* 8 (pi-sum 1 10000))


(define (sum term a next b)
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(define (sum2 term a next b)
  (define (iter a result)
    (if (> a b) 
      result
      (iter (next a) (+ (term a) result)))) 
  (iter a 0))


(define (pi-sum2 a b)
  (define (pi-term x)
    (/ 1.0 (* x (+ x 2))))
  (define (pi-next x)
    (+ x 4))
  (sum2 pi-term a pi-next b))

(* 8 (pi-sum2 1 10000))

(define (product term a next b)
  (if (> a b)
    1
    (* (term a)
       (sum term (next a) next b))))

(define (square x) (* x x))
(define (inc n) (+ n 1))
(define (product-square a b)
  (product square a inc b))

(product-square 2 3)
