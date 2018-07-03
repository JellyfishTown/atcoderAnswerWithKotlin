fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map(String::toInt)
    val xList = readLine()!!.split(' ').map(String::toInt)
    val cList = mutableListOf<Int>()
    val dList = mutableListOf<Int>()
    for (i in 0 until q) {
        val (c, d) = readLine()!!.split(' ').map(String::toInt)
        cList.add(c)
        dList.add(d)
    }
    for (i in 0 until q) {
        if (dList[i] == 0) {
            println(0)
            continue
        }

        var result: Long = n.toLong() * dList[i].toLong()
        val first = xList.fastIndexOfFirst { it > cList[i] - dList[i] }
        val last = xList.fastIndexOfLast { it < cList[i] + dList[i] }
        if (first != -1 && last != -1) {
            for (j in first..last) {
                result -= dList[i] - Math.abs(xList[j] - cList[i])
            }
        }
        println(result)
    }
}

//二分探索、ソート済みリストに対して与えられた条件を満たす最後のindexを返す
inline fun <T> List<T>.fastIndexOfLast(predicate: (T) -> Boolean): Int {
    var left = 0L
    var right = size - 1L
    var tflag = false
    while (left < right) {
        val index = ((left + right) / 2).toInt()
        if (predicate(this[index])) {
            left = index + 1L
            tflag = true
        } else {
            right = index.toLong()
        }
    }
    return if (predicate(this[left.toInt()])) {
        left.toInt()
    } else if (!tflag) {
        -1
    } else {
        left.toInt() - 1
    }
}

//二分探索、ソート済みリストに対して与えられた条件を満たす最初のindexを返す
inline fun <T> List<T>.fastIndexOfFirst(predicate: (T) -> Boolean): Int {
    var left = 0L
    var right = size - 1L
    while (left < right) {
        val index = ((left + right) / 2).toInt()
        if (predicate(this[index])) {
            right = index.toLong()
        } else {
            left = index + 1L
        }
    }
    return if (predicate(this[left.toInt()])) {
        left.toInt()
    } else {
        -1
    }
}