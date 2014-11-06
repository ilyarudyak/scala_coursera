implicit def intToRational(x: Int) = new Rational(x)


val a = new Rational(1,2)
val b = new Rational(1,4)

println(a + b)

println(a * 8)
println(8 * a)

println(new Rational(2))


