package participated.abc135

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    if ((a - b) % 2 == 0L) {
        println((a + b) / 2)
    } else {
        println("IMPOSSIBLE")
    }
}
