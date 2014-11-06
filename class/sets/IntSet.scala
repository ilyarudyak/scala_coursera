abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}


class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x) 
    else this

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def union(other: IntSet): IntSet = 
    ((left union right) union other) incl elem
    


  override def toString = "{" + left + elem + right + "}"


}// end of class NonEmpty

val t1 = new NonEmpty(1, new Empty, new Empty)
val t2 = new NonEmpty(2, new Empty, new Empty)
println(t1)
println(t2)
println(t1 union t2)



