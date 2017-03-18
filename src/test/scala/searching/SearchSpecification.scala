package searching

import org.scalacheck.{Prop, Properties}
import searching.Search._
import org.scalatest
import org.scalatest.FlatSpec

trait Fixture1 {
  val lista = List(0,1,2,3,4,5,6,7,8,9)
}

class SearchingTest extends FlatSpec with Fixture1 {
  "Searching an element in Nil" should "raise an exception" in {
    assertThrows[IllegalArgumentException]{
      binarySearch(Nil, 9)
    }
  }

  "Searching element in non-empty sorted list" should "return correct index" in {
    val targetIdx = binarySearch(lista, 7)
    assert(lista(targetIdx) == 7)
  }
  it should "return -1 if list does not contain the element" in {
    val targetIdx = binarySearch(lista, 77)
    assert(targetIdx == -1)
  }
}

// TODO: Investigate why those don't work
//object SearchSpecification extends Properties("Searching"){
//  property("binarySearch") = Prop.forAll { (arr: List[Int], target: Int) =>
//    lazy val targetIdx: Int = binarySearch(arr, target)
//    if(arr.isEmpty) Prop.throws(
//      classOf[IllegalArgumentException]
//    ){targetIdx}
//    else {
//      (targetIdx == -1) || (arr(targetIdx) == target)
//    }
//  }
//}




