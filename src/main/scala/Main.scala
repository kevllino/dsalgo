import searching.Search._
import sorting.Sorting

object Main extends App{


  def mergeSort(lista: List[Int]): List[Int] = {
    val mid = lista.length / 2
    if (mid == 0) {
      lista
    } else {
      def merge(left: List[Int], right: List[Int]): List[Int] = {
        (left, right) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (hl :: tl, hr :: tr) => if (hl > hr) hr :: merge(left, tr) else hl :: merge(tl, right)
        }
      }
      val (leftList, rightList) = lista.splitAt(mid)
      merge(mergeSort(leftList), mergeSort(rightList))
    }
  }


  def quickSort(lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case pivot :: rest =>  {
      val (smaller, equal, larger) = partition(pivot, lista, Nil, Nil, Nil)
      quickSort(smaller) ++ equal ++ quickSort(larger)
    }
  }


  def partition(pivot: Int, rest: List[Int], smaller: List[Int], equal: List[Int], larger: List[Int]): (List[Int], List[Int], List[Int]) =
    rest match {
      case Nil => (smaller, equal, larger)
      case h :: t if h > pivot => partition(pivot, t, smaller, equal, h :: larger)
      case h :: t if h < pivot => partition(pivot, t, h :: smaller, equal, larger)
      case h :: t if h == pivot => partition(pivot, t,smaller, h :: equal, larger)
    }

  val list1 = List(1,99,8, 23, 3,2 ,2)
  val sortedList1 = mergeSort(list1)
  println(sortedList1)

  val sortedList2 = quickSort(list1)
  println(sortedList2)

  // print(binarySearch(List(), 1))

}
