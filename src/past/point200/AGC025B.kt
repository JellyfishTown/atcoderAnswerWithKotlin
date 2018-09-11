

private const val MOD: Long = 998244353
private var FACT: LongArray? = null
private var IFACT: LongArray? = null


fun main(args: Array<String>) {
    val (n, a, b,K) = readLine()!!.split(" ").map(String::toLong)
    val N = n.toInt()
    val A = a.toInt()
    val B = b.toInt()
    solve(N, A, B, K)
}

private fun solve(N: Int, A: Int, B: Int, K: Long) {
    FACT = LongArray(N + 1)
    IFACT = LongArray(N + 1)
    FACT!![0] = 1
    IFACT!![0] = 1
    for (i in 1..N) {
        FACT!![i] = FACT!![i - 1] * i % MOD
        IFACT!![i] = inv(FACT!![i])
    }

    var ans: Long = 0
    println("5:2 :${comb(5,2)}")
    println("10:2 :${comb(10,2)}")
    for (numA in 0..N) {
        val rem = K - A.toLong() * numA
        if (rem < 0) {
            break
        }
        val numB = (rem / B).toInt()
        if (A.toLong() * numA + B.toLong() * numB == K && numB <= N) {
            ans = (ans + comb(N, numA) * comb(N, numB)) % MOD
        }
    }
    println(ans)
}

private fun comb(n: Int, r: Int): Long {
    var r = r
    if (n < 0 || r < 0 || n < r) {
        return 0
    }
    if (r > n / 2) {
        r = n - r
    }
    return FACT!![n] * IFACT!![n - r] % MOD * IFACT!![r] % MOD
}

private fun inv(a: Long): Long {
    var a = a
    var b = MOD
    var p: Long = 1
    var q: Long = 0
    while (b > 0) {
        val c = a / b
        var d: Long = a
        a = b
        b = d % b
        d = p
        p = q
        q = d - c * q
    }
    return if (p < 0) p + MOD else p
}


//import java.math.BigDecimal
//
//fun past.point300.past.point300.past.point300.past.point200.past.point400.past.point200.past.point200.past.point200.past.point400.abc106.abc104.main(args: Array<String>) {
//    val (N, A, B, K) = readLine()!!.split(" ").map(String::toLong)
//    var ans = BigDecimal(0)
//    for (a in 0..N) {
//        val temp = K - (A * a)
//        if (temp % B != 0L) continue
//        val b = temp / B
//        ans = ans.add(calcCombination(N, a)!!.multiply(calcCombination(N, b)) )
//        ans = ans.remainder(BigDecimal(998244353))
//    }
//    println(ans.toLong())
//}
//
//fun calcCombination(n: Long, r: Long): BigDecimal? {
//    var bunbo = BigDecimal(1)
//    var bunshi = BigDecimal(1)
//    for (i in 0..(r - 1)) {
//        bunbo = bunbo.multiply(BigDecimal(n - i))
//        bunshi = bunshi.multiply(BigDecimal(r - i))
//    }
//    return bunbo.divide(bunshi)
//}