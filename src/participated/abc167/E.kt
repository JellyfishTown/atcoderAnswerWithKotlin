package participated.abc167

fun main(args: Array<String>) {
    val mod = 998244353L

    class BulkCombination(n: Int, val mod: Long = 998244353L) {

        private val factorial = LongArray(n + 1) { 1 }
        private val inverse = LongArray(n + 1) { 1 }
        private val factorialInverse = LongArray(n + 1) { 1 }

        init {
            for (i in 2..n) {
                factorial[i] = (factorial[i - 1] * i.toLong() % mod)
                inverse[i] = (mod - inverse[mod.toInt() % i] * (mod / i.toLong()) % mod)
                factorialInverse[i] = (factorialInverse[i - 1] * inverse[i] % mod)
            }
        }

        fun nCm(n: Int, m: Int): Long {
            return factorial[n] * (factorialInverse[m] * factorialInverse[n - m] % mod) % mod
        }

        fun nHm(n: Int, m: Int): Long {
            return nCm(n + m - 1, m)
        }
    }

    val (n, m, k) = readLine()!!.split(' ').map(String::toLong)
    val c = BulkCombination(n.toInt() - 1)
    val mo = LongArray(n.toInt() + 1) { 1 }
    mo[1] = m - 1
    for (i in 2..n.toInt()) {
        mo[i] = (mo[i - 1] * (m - 1)) % mod
    }
    var ans = 0L
    for (i in 0..k.toInt()) {
        var temp = m
        temp *= mo[n.toInt() - 1 - i]
        temp %= mod
        temp *= (c.nCm(n.toInt() - 1, i)) % mod
        temp %= mod
        ans += temp
        ans %= mod
    }
    println(ans)
}
