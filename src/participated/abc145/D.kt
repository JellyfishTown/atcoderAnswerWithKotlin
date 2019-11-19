package participated.abc145

fun main(args: Array<String>) {
    fun pow(a: Long, b: Long, mod: Long): Long {
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

    fun nCk(n: Long, k: Long, mod: Long): Long {
        var ret: Long = 1
        val min = Math.min(k, n - k)
        for (i in 1..min) {
            ret = ret * pow(i, (mod - 2), mod) % mod
        }
        for (i in n - min + 1..n) {
            ret = ret * i % mod
        }
        return ret
    }


    val mod = 1000000007L
    val (x, y) = readLine()!!.split(' ').map(String::toLong)

    val totalMove = (x + y) / 3
    val countU = y - totalMove
    val countR = x - totalMove
    if ((x + y) % 3 != 0L || countU < 0 || countR < 0) {
        println(0)
        return
    }
    println(nCk(totalMove, countR, mod) % mod)
}
