package participated.abc156

fun main(args: Array<String>) {
    val mod = 1000000007L
    fun pow(a: Long, b: Long): Long {
        var bt = b
        var ret: Long = 1
        var tmp = a
        while (bt > 0) {
            if (bt and 1 == 1L) ret = ret * tmp % mod
            tmp = tmp * tmp % mod
            bt = bt shr 1
        }
        return ret
    }

    fun nCk(n: Long, k: Long): Long {
        var ret: Long = 1
        val min = Math.min(k, n - k)
        for (i in 1..min) {
            ret = ret * pow(i, (mod - 2)) % mod
        }
        for (i in n - min + 1..n) {
            ret = ret * i % mod
        }
        return ret
    }
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    var base = pow(2, n) - 1 + mod
    val minus = (nCk(n, a) + nCk(n, b))%mod
    println((base - minus) % mod)
}
