package participated.abc140

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val bList = readLine()!!.split(' ').map(String::toLong)
    val aList = Array(n) { 0L }
    aList[n - 1] = bList.last()
    aList[0] = bList.first()
    (n - 2 downTo 1).forEach {
        aList[it]=Math.min(bList[it],bList[it-1])
    }
    println(aList.sum())
}