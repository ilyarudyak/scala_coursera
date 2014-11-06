package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times") {
    assert( times(List('a', 'b', 'a')) === List(('b',1), ('a', 2))  )
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("insert") {
    val leaf1 = Leaf('a', 1)
    val list1 = List( Leaf('b', 2), Leaf('c', 5) )
    val listC1 = List( Leaf('a', 1), Leaf('b', 2), Leaf('c', 5) )

    val leaf2 = Leaf('a', 3)
    val list2 = List( Leaf('b', 2), Leaf('c', 5) )
    val listC2 = List( Leaf('b', 2),  Leaf('a', 3), Leaf('c', 5) )

    val leaf3 = Leaf('a', 7)
    val list3 = List( Leaf('b', 2), Leaf('c', 5) )
    val listC3 = List( Leaf('b', 2), Leaf('c', 5), Leaf('a', 7) )

    val leaf4 = Leaf('a', 1)
    val listC4 = List(leaf4)

    val fork5 = Fork(Leaf('x', 10), Leaf('y', 20), List('a'), 1)
    val list5 = List( Leaf('b', 2), Leaf('c', 5) )
    val listC5 = List( fork5, Leaf('b', 2), Leaf('c', 5) )

    assert( insert(leaf1, list1) === listC1 )
    assert( insert(leaf2, list2) === listC2 )
    assert( insert(leaf3, list3) === listC3 )
    assert( insert(leaf4, Nil) === listC4 )
    assert( insert(fork5, list5) === listC5 )
  }

  test("combine of some leaf list") {
    val list = List(Leaf('a', 1), Leaf('b', 2), Leaf('c', 4))
    val listCombined = List( Fork(Leaf('a',1), Leaf('b',2), List('a', 'b'), 3), Leaf('c',4) )

    assert( combine(list) === listCombined )
  }

  test("decode"){
    new TestTrees {
      val bits = List(0,1)
      //println(decode(t1, bits))
    }
  }
  
  test("decodeSecret") {

    assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      println()
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
