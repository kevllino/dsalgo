import sorting.Sorting._

object Main extends App{

  val list1 = List(1,99,8, 23, 3,2 )
  val sortedList1 = mergeSort(list1)
  println(sortedList1)

  val sortedList2 = quickSort(list1)
  println(sortedList2)

}
