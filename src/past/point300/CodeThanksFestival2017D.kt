fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toLong)
    fun gcd(a: Long, b: Long): Long = if (b > 0) gcd(b, a % b) else a
    println(m - gcd(n, m))
}
