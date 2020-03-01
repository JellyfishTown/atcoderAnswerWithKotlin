package participated.abc153

fun main(args: Array<String>) {
    val h = readLine()!!.toLong()
    var times = 1L
    while (times < h) times = times * 2 + 1
    println(times)
}