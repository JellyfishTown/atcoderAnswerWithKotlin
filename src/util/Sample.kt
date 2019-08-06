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
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).reversed()
    var count = 0
    if(aList[0]>0)count++
    (0 until aList.size - 1).forEach {
        if(aList[it]<aList[it+1])count++
    }
    println(count)
}
