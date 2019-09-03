package participated.abc137

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    println(Math.max(Math.max(a * b, a + b), a - b))
}
