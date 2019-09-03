package participated.abc139

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    println(Math.ceil((b - a).toDouble() / (a - 1).toDouble()).toLong() + 1)
}
