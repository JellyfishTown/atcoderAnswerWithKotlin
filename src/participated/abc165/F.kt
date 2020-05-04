package participated.abc165

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val aList = (1..n).map { readLine()!!.toLong() }
    val bList = readLine()!!.split(' ').map(String::toLong)
    val cdList = (1..n).map {
        val (c, d) = readLine()!!.split(' ').map(String::toLong)
        Pair(c, d)
    }
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)

    if (true) {
        println()
    } else {
        println()
    }
}
