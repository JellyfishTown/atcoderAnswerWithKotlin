package participated.abc140

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val bList = readLine()!!.split(' ').map(String::toLong)
    val cList = readLine()!!.split(' ').map(String::toLong)

    var sum = bList.sum()
    (0 until n - 1).forEach { if (aList[it] + 1 == aList[it + 1]) sum += cList[aList[it].toInt()-1] }
    println(sum)
}