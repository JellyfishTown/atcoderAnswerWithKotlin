package participated.abc152

//最小公倍数
fun main(args: Array<String>) {
    val mod = 1000000007L
    fun divWithMod(a: Long, b: Long, mod: Long): Long {
        return ((a % mod) * java.math.BigInteger.valueOf(b).modInverse(java.math.BigInteger.valueOf(mod)).toLong()) % mod
    }

    fun calcFactors(n: Int): Map<Int, Int> {//素因数分解
        val factors = mutableMapOf<Int, Int>()
        var tmp = n
        var i = 2
        while (i * i <= tmp) {
            while (tmp % i == 0) {
                factors[i] = factors.getOrElse(i) { 0 } + 1
                tmp /= i
            }
            i++
        }
        if (tmp > 1) factors[tmp] = 1
        return factors
    }

    readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).toLongArray()
    val totalFactors = mutableMapOf<Int, Int>()
    for (a in aList) {
        val factors = calcFactors(a.toInt())
        for (key in factors.keys) {
            totalFactors[key] = Math.max((totalFactors.get(key) ?: 0), factors[key]!!)
        }
    }

    var koubai = 1L
    for (key in totalFactors.keys) {
        for (i in 1..totalFactors[key]!!) {
            koubai *= key
            koubai %= mod
        }
    }
    var ans = 0L
    for (a in aList) {
        ans += divWithMod(koubai, a, mod)
        ans %= mod
    }
    println(ans)
}