package participated.abc142

fun main(args: Array<String>) {
    fun gcd(a: Long, b: Long): Long {
        return if (b > 0) gcd(b, a % b) else a
    }

    fun calcFactors(n: Long): Map<Long, Long> {//素因数分解
        val factors = mutableMapOf<Long, Long>()
        var tmp = n
        var i = 2L
        while (i * i <= tmp) {
            while (tmp % i == 0L) {
                factors[i] = factors.getOrElse(i) { 0 } + 1
                tmp /= i
            }
            i++
        }
        if (tmp > 1) factors[tmp] = 1
        return factors
    }

    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    val gcd = gcd(a, b)
    val factors = calcFactors(gcd)
    println(factors.size + 1)

}