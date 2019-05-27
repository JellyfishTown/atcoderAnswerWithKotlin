package participated.abc128
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val aList = mutableListOf<Long>()
    (1..n).forEach { aList.add(readLine()!!.toLong()) }
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)


    println()
}
