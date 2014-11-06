def whileAwesome(conditional: => Boolean)(f: => Unit) { 
  if (conditional) {
    f
    whileAwesome(conditional)(f) 
  }
}

var count = 0

whileAwesome(count < 5) { 
  println("still awesome")
  count += 1 
}
