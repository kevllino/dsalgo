package sorting

/**
  * Created by keid on 20/02/2017.
  */
object Sorting {

  def mergeSort(xs: List[Int]): List[Int] = {
    val mid = xs.length / 2
    if (mid == 0) xs
    else {
      def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
        case (ys, Nil) => ys
        case (Nil, zs) => zs
        case (y :: ys, z :: zs) => if (y > z) z :: merge(left, zs) else y :: merge(ys, right)
      }
      val (leftHalf, rightHalf): (List[Int], List[Int]) = xs splitAt mid
      merge(mergeSort(leftHalf), mergeSort(rightHalf))
    }
  }

  def quickSort(lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case pivot :: rest => {
     val (smaller, equal,larger) = partition(pivot, lista, Nil, Nil, Nil)
      quickSort(smaller) ++ equal ++ quickSort(larger)
    }
  }

  def partition(pivot: Int, rest : List[Int], smaller: List[Int], equal: List[Int],larger: List[Int]): (List[Int], List[Int], List[Int]) = rest match {
    case Nil => (smaller, equal, larger)
    case h :: t if h == pivot => partition(pivot, t, smaller, h :: equal, larger)
    case h :: t if h < pivot => partition(pivot, t, h :: smaller, equal, larger)
    case h :: t if h > pivot => partition(pivot, t, smaller, equal, h :: larger)
  }
}
