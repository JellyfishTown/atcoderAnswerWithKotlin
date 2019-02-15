val abMap = mutableMapOf<Int, Int>()
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val (a, b) = readLine()!!.split(" ").map(String::toInt)
        abMap[a] = b
    }
    val key = abMap.keys.sorted()
    val m = readLine()!!.toInt()
    for (i in 1..m) {
        val t = readLine()!!.toInt()
        if (t < key.first()) {
            println(abMap[key.first()])
        } else if (t > key.last()) {
            println(abMap[key.last()]!! + t - key.last())
        } else {
            val lasti = key.indexOfFirstByBinary { it > t } - 1
            val keyl = key[lasti]
            val keyr = key[lasti + 1]
            val costl = abMap[keyl]!!
            val costr = abMap[keyr]!!
            println(Math.min(costl + t - keyl, costr))
        }
    }
}

inline fun <T> List<T>.indexOfFirstByBinary(predicate: (T) -> Boolean): Int {
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
