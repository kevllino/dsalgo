package sorting

import org.scalacheck.{Prop, Properties}
import Sorting._
/**
  * Created by keid on 18/03/2017.
  */
object SortingSpecification extends Properties("sorting"){
  property("quicksort") = Prop.forAll { (lista: List[Int]) =>
    quickSort(lista) == lista.sorted
  }
  property("mergesort") = Prop.forAll { (lista: List[Int]) =>
    mergeSort(lista) == lista.sorted
  }
}
