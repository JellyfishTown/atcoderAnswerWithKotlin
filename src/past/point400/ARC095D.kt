fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    println("${aList.last()} ${aList.take(n - 1).minBy { Math.abs(aList.last().toDouble() / 2 - it) }!!}")
}