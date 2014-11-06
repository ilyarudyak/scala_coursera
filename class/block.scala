val x = 0
def f(y: Int) = y + 1

val result = {
  val x = f(3) // x == 4
  x * x // x is shadowed 16
} + x // x == 0 again 16

println(result)
