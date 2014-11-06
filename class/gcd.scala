
def gcd(x: Int, y: Int): Int = {

  if (y == 0) x
  else gcd(y, x % y)

}

println(gcd(14, 21))
