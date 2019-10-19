package past.other.internal.m5

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    var min = Long.MAX_VALUE
    for (i in 0 until n) {
        min = Math.min(min, Math.abs(aList[i] - aList[i + n]))
    }
    println(min)
}