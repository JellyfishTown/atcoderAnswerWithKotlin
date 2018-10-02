package participated.abc109

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    println(if (a % 2L == 1L && b % 2L == 1L) "Yes" else "No")
}
