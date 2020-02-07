package participated.abc148

fun main(args: Array<String>) {
    fun gcd(a: Long, b: Long): Long = if (b > 0) gcd(b, a % b) else a
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    println(a * b / gcd(a, b))
}