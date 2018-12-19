package past.other.typicaldp

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt)
    val bList = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(10101) { false }
    println(dp.count { it })
}
