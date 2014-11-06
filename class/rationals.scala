class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational): Rational = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom)

  def neg() = new Rational(-numer, denom)

  def sub(that: Rational): Rational = new Rational(
    numer * that.denom - that.numer * denom,
    denom * that.denom)


  override def toString() =
    numer + "/" + denom
}


val x = new Rational(1,2)
println(x)

val y = new Rational(2,3)
println(y)
println(x.add(y))
println("---")

println(x.neg)
println(y.sub(x))




