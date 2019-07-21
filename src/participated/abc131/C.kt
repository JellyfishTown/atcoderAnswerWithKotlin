package participated.abc131

fun main(args: Array<String>) {
    fun gcd(a: Long, b: Long): Long {
        return if (b > 0) gcd(b, a % b) else a
    }
    val (a, b, c, d) = readLine()!!.split(' ').map(String::toLong)
    var total = b - a + 1
    total -= b / c
    total += (a - 1) / c
    total -= b / d
    total += (a - 1) / d
    total += b / (d * c / gcd(d,c))
    total -= (a - 1) / (d * c / gcd(d,c))

    println(total)
}
