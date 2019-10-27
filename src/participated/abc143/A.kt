package participated.abc143

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)

    println(Math.max(a - b - b, 0))
}