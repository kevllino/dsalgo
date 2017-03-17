package searching

object Search {

  def binarySearch(arr: Array[Int], target: Int): Int = {
    def go(arr: Array[Int], target: Int, start: Int, end: Int): Int = {
      assert(start != end)
      val mid = (start + end) / 2

      arr match {
        case xs if (xs(mid) == target) => mid
        case xs if (xs(mid) > target) => go(xs, target, start, mid - 1)
        case xs if (xs(mid) < target) => go(xs, target, mid + 1, end)
      }
    }
    go(arr, target, 0, arr.length)
  }
}
