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
    val (n, k) = readLine()!!.split(' ').map(String::toLong)

    if (n <= k + 1) {
        println(nCk(n * 2 - 1, n - 1) % mod)
    } else {
        val x = n*(n-1)
        var ans = x
        for(i in 1..k){
            ans *= x
            ans/=2
            ans%=mod
        }
        println(ans)
    }
}
