// simple sum
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b)

def sumInt(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInt(a + 1, b)

println(sumInt(3,5))

def sumInt2(a: Int, b: Int): Int = sum(x => x, a, b)
println(sumInt2(3,5))

def sumSquares(a: Int, b: Int): Int = sum(x => x*x, a, b)
println(sumSquares(3,5))

// tail recursive sum
def sum2(f: Int => Int, a: Int, b: Int): Int = {

  def g(a: Int, acc: Int): Int = {
    if (a > b) acc else g(a+1, f(a)+acc)
  }
  
  g(a,0)
}
println( sum2(x => x*x, 3, 5) )
println("---")

// sum3 returns a function
def sum3(f: Int => Int): (Int, Int) => Int = {
    def g(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + g(a + 1, b)
    g
}
println( sum3(x => x*x)(3, 5) )

// curried form of sum
def sum4(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum4(f)(a + 1, b)
println( sum4(x => x*x)(3, 5) )


