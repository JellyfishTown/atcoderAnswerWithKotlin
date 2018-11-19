package participated.abc112

fun main(args: Array<String>) {
    val (n, t) = readLine()!!.split(' ').map(String::toLong)
    var min = Long.MAX_VALUE
    for (i in 1..n) {
        val (c, temp) = readLine()!!.split(' ').map(String::toLong)
        if (temp <= t) min = Math.min(min, c)
    }
    if (min == Long.MAX_VALUE) {
        println("TLE")
    } else {
        println(min)
    }
}


