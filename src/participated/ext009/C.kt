package participated.ext009

fun main(args: Array<String>) {
    val mod = 1000000007
    fun pow(x: Long, y: Long): Long {
        if (y == 0L) {
            return 1L
        } else if (y % 2 == 0L) {
            val a = pow(x, y / 2)
            return a * a % mod
        } else {
            val a = pow(x, y / 2)
            return a * a % mod * x % mod
        }
    }

    fun div(x: Long, y: Long): Long {
        return x * pow(y, (mod - 2).toLong()) % mod
    }

    val (n, a, b, c) = readLine()!!.split(' ').map(String::toLong)
    val aPct = div(a, a + b)
    val bPct = div(b, a + b)

    var comb = 1L
    var ans = 0L
    for (i in 0 until n) {
        ans += pow(aPct, n) * pow(bPct, i) % mod * comb % mod * (n + i) % mod
        ans %= mod.toLong()
        ans += pow(bPct, n) * pow(aPct, i) % mod * comb % mod * (n + i) % mod
        ans %= mod.toLong()
        comb = div(comb * (n + i) % mod, (i + 1))
    }
    val l = div(a + b, 100)
    println(div(ans, l))
}

