package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = (readLine()!!.split(' ').map(String::toInt).sorted())
    val bList = (readLine()!!.split(' ').map(String::toInt).sorted())
    val cList = (readLine()!!.split(' ').map(String::toInt).sorted())

    var count = 0L
    for (i in 0 until n) {
        val aCount = aList.fastIndexOfLast { it < bList[i] } + 1
        val indexOfFirst = cList.fastIndexOfFirst { it > bList[i] }
        val cCount = if (indexOfFirst < 0) 0 else cList.size - indexOfFirst
        count += aCount * cCount
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

inline fun <T> List<T>.fastIndexOfFirst(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    var allFalse = true
    while (left < right) {
        val index = ((left + right) / 2)
        if (predicate(this[index])) {
            right = index
            allFalse = false
        } else {
            left = index + 1
        }
    }
    return if (predicate(this[left])) {
        left
    } else if (allFalse) {
        return -1
    } else {
        left - 1
    }
}
