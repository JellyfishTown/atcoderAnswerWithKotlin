package past.point200

fun main(args: Array<String>) {
    val (a, b, k) = readLine()!!.split(" ").map(String::toInt)
    if (b - a < 2 * k) {
        for (i in a..b) println(i)
    } else {
        for (i in 0 until k) {
            println(a + i)
        }
        for (i in 0 until k) {
            println(b - k + i + 1)
        }
    }
}