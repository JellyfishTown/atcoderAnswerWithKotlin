package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var temp = readLine()!!.toLong()
    for (i in 1 until n) {
        val t = readLine()!!.toLong()
        temp = koubai(temp, t)
    }
    println(temp)
}


fun koubai(n1: Long, n2: Long): Long {
    var temp: Long
    var m = n1
    var n = n2
    while (m % n != 0L) {
        temp = n
        n = m % n
        m = temp
    }
    return n1 / n * n2
}

