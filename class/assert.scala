var assertionsEnabled = false

def myAssert(predicate: => Boolean) = {
    if (assertionsEnabled && !predicate)
      throw new AssertionError
  
  }

  println(myAssert(5/0 == 0))
