package searching

object Search {

  def binarySearch(arr: List[Int], target: Int): Int = {
    require(!arr.isEmpty, "array should not be empty")
    def go(arr: List[Int], target: Int, start: Int, end: Int): Int = {
      if (start > end) return -1
      val mid = (start + end) / 2
      arr match {
        case xs:List[Int]  if (xs(mid) == target) => mid
        case xs:List[Int] if (xs(mid) > target) => go(xs, target, start, mid - 1)
        case xs:List[Int] if (xs(mid) < target) => go(xs, target, mid + 1, end)
      }
    }
   go(arr.sorted, target, 0, arr.length - 1)
  }
}


