def product(f: Int => Int)(a: Int, b: Int): Int = 
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

println( product(x => x)(3, 5) )

def fact(n: Int) = product(x => x)(1, n)

println(fact(5))

def g(op: Int => Int)(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a).op( product(f)(a + 1, b) ) 
println( g(*)(x => x)(3, 5) )

