package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = (readLine()!!.split(' ').map(String::toInt).sorted())
    val bList = (readLine()!!.split(' ').map(String::toInt).sorted())
    val cList = (readLine()!!.split(' ').map(String::toInt).sortedDescending())

    var count = 0L
    for (i in 0 until n) {
        val aCount = aList.fastIndexOfLast { it < bList[i] } + 1
        val cCount = cList.fastIndexOfLast { it > bList[i] } + 1
        count += aCount.toLong() * cCount.toLong()
    }
    println(count)
}

inline fun <T> List<T>.fastIndexOfLast(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    while (left < right) {
        val index = ((left + right) / 2)
        if (predicate(this[index])) {
            left = index + 1
        } else {
            right = index
        }
    }
    return if (predicate(this[left])) {
        left
    } else {
        left - 1
    }
}