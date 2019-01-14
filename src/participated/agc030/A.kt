package participated.agc030

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)
    println(Math.min(a + b + 1, c) + b)
}
