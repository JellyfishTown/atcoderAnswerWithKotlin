package participated.abc160

fun main(args: Array<String>) {
    val (k, n) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    var max = Long.MIN_VALUE
    (1 until n.toInt()).forEach {
        max = Math.max(max, aList[it] - aList[it - 1])
    }
    max = Math.max(max, aList.first() + (k - aList.last()))
    println(k-max)
}
