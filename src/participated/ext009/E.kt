package participated.ext009

import java.math.BigInteger

fun main(args: Array<String>) {
    val mod = 1000003L
    val mods = Array(mod.toInt() + 1) { -1L }
    fun divWithMod(a: Long, b: Long): Long {
        if (mods[b.toInt()] == -1L) {
            mods[b.toInt()] = ((a % mod) * BigInteger.valueOf(b).modInverse(BigInteger.valueOf(mod)).toLong()) % mod
        }
        return mods[b.toInt()]
    }

    fun pow(a: Long, b: Long): Long {
        var bt = b
        var ret = 1L
        var at = a
        while (bt > 0) {
            if (bt and 1 == 1L) ret = ret * at % mod
            at = at * at % mod
            bt = bt shr 1
        }
        return ret
    }

    val fact = mutableListOf(0L, 1L)
    (2..mod).forEach { fact.add(it * fact[it.toInt() - 1] % mod) }

    val q = readLine()!!.toInt()
    for (i in 1..q) {
        val (x, d, n) = readLine()!!.split(' ').map(String::toLong)
        if (d == 0L) {
            println(pow(d, n))
        } else {
            val powd = pow(d, n)
            val fact1 = fact[(divWithMod(x, d) + (n - 1)).toInt() % mod.toInt()]
            val fact2 = fact[(divWithMod(x, d) - 1).toInt() % mod.toInt()]
            val ans = divWithMod(powd * fact1, fact2)
            println(ans)
        }
    }
}

//fun past.point100.past.point300.main(args: Array<String>) {
//    val mod = 1000003L
//    fun divWithMod(a: Long, b: Long): Long {
//        return ((a % mod) * b.toBigInteger().modInverse(mod.toBigInteger()).toLong()) % mod
//    }
//
//    fun pow(a: Long, b: Long): Long {
//        var bt = b
//        var ret: Long = 1
//        var tmp = a
//        while (bt > 0) {
//            if (bt and 1 == 1L) ret = ret * tmp % mod
//            tmp = tmp * tmp % mod
//            bt = bt shr 1
//        }
//        return ret
//    }
//
//    val fact = mutableListOf<Long>()
//    fact.add(0)
//    fact.add(1)
//    (2..mod).forEach { fact.add(it * fact[it.toInt() - 1] % mod) }
//
//    val q = readLine()!!.toInt()
//    for (i in 1..q) {
//        val (x, d, n) = readLine()!!.split(' ').map(String::toLong)
//        val array = (0 until n).map { x + it * d }
//        val arrayd = array.map { divWithMod(it,d)}
//        if (d == 0L) {
//            println(pow(d, n))
//        } else {
//            val pow = pow(d, n)
//            val toInt = (divWithMod(x, d) + (n - 1)).toInt()
//            val fact1 = fact[toInt]
//            val toInt1 = (divWithMod(x, d) - 1).toInt()
//            val fact2 = fact[toInt1]
//            val ans = divWithMod(pow * fact1, fact2)
//            println(ans)
//        }
//    }
//}
