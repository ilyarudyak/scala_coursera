
def sqrt(x: Double) = {

  def sqrtIter(guess: Double): Double = 
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))


  def improve(guess: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double) = 
    abs(guess * guess - x) < 0.001

  def abs(x: Double) =
    if ( x >= 0) x
    else -x

  sqrtIter(1.0)

}

println(sqrt(9))

