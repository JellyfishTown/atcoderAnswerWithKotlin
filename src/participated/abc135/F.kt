package participated.abc135

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val aList = mutableListOf<Long>()
    val bList = readLine()!!.split(' ').map(String::toLong)
    (1..n).forEach { aList.add(readLine()!!.toLong()) }
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)


    println()
}
