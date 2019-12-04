package past.point400

//階乗 逆元 nCr
fun main(args: Array<String>) {
    val mod = 1000000007L
    fun divWithMod(a: Long, b: Long): Long {
        return ((a % mod) * java.math.BigInteger.valueOf(b).modInverse(java.math.BigInteger.valueOf(mod)).toLong()) % mod
    }
    val (h, w, a, b) = readLine()!!.split(' ').map(String::toLong)
    val dataNum = (h + w).toInt()
    val facts = LongArray(dataNum + 1) { 1 }
    (1..dataNum).forEach { facts[it] = (facts[it - 1] * it) % mod }

    var ans = 0L
    for (tw in b + 1..w) {
        val th = h - a
        val m1_1 = facts[(th + tw - 2).toInt()]
        val m1_2 = if (th != 1L) divWithMod(m1_1, facts[th.toInt() - 1]) else m1_1
        val m1_3 = if (tw != 1L) divWithMod(m1_2, facts[tw.toInt() - 1]) else m1_2

        val m2_1 = facts[(a + (w - tw + 1) - 2).toInt()]
        val m2_2 = if (a != 1L) divWithMod(m2_1, facts[a.toInt() - 1]) else m2_1
        val m2_3 = if ((w - tw + 1) != 1L) divWithMod(m2_2, facts[(w - tw + 1).toInt() - 1]) else m2_2

        ans += (m1_3 * m2_3) % mod
        ans %= mod
    }
    println(ans)
}
