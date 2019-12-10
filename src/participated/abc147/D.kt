package participated.abc147

fun main(args: Array<String>) {
    val mod = 1000000007L
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map { java.lang.Long.toBinaryString(it.toLong()).reversed() }
    val sumArray = Array(100) { 0L }
    for (a in aList) {
        var i = 0
        while (true) {
            sumArray[i] += a.getOrNull(i)?.toString()?.toLong() ?: break
            i++
        }
    }
    var ans = 0L
    (0 until 100).forEach {
        ans += (((sumArray[it] * (n.toLong() - sumArray[it]))%mod)
                * (Math.pow(2.toDouble(), it.toDouble()) % mod).toLong()) % mod
        ans %= mod
    }
    println(ans)
}
