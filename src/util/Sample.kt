package util

//条件式を適用した結果も{False,False,True,True}の様にソートされているもののみに適用可能である
inline fun <T> List<T>.indexOfFirstByBinarySearch(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    while (left < right) {
        if (predicate(this[left])) {
            return left
        }
        if (!predicate(this[right])) {
            return -1
        }
        val middle = ((left + right) / 2)
        if (predicate(this[middle])) {
            right = middle
        } else {
            left = middle + 1
        }
    }
    return if (predicate(this[left])) left else -1
}

fun main(args: Array<String>) {
    val data = arrayOf(10, 20, 20, 30, 30, 30, 40, 40, 40, 40, 50)

}
