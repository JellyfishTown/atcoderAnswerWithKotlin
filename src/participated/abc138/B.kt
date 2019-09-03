package participated.abc138

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toDouble)
    var sum = 0.0
    for (a in aList) {
        sum += 1.0 / a
    }
    println(1.0 / sum)
}
