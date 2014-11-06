def factorial(n: BigInt): BigInt = {
  def fact(n: BigInt, acc: BigInt): BigInt = n match {
    case _ if n == 1 => acc
    case _ => fact(n-1, n*acc)
  }
  fact(n, 1)
}

println(factorial(1000))
