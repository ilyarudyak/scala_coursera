// pattern matching

// 1) standard matching on variable
val r = ...
r match {
  case 7 => ...
  case _ => ... // we may put here case x => println(x)
}

// 2) match on type
val x = ...
x match {
  case i: Int => println() // so we put here case i: Int, not case Int
}

// 3) match on sequencies
val list = List(1,2,3,4)
list match {
  case List(_,2,_,_) => ...
  case List(_*)
}

list match {
  case head :: tail => ... // extract head and tail
}

//  other: 4) case classes 5) tuples 6) regex
