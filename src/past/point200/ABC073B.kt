package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var count = 0
    for (i in 1..n) {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        count += r - l + 1
    }
    println(count)
}