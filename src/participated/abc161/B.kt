package participated.abc161

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val sum = aList.sum()

    if (aList[m - 1].toDouble() >= sum.toDouble() / (4.toDouble() * m.toDouble())) {
        println("Yes")
    } else {
        println("No")
    }
}
