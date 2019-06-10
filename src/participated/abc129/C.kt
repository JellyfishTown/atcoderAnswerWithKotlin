package participated.abc129

fun main(args: Array<String>) {
    val mod = 1000000007L
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = mutableListOf<Long>()
    if (m > 0L) {
        aList.add(readLine()!!.toLong())
    }
    (1 until m).forEach {
        val a = readLine()!!.toLong()
        if (aList.last() + 1 == a) {
            println(0)
            return
        }
        aList.add(a)
    }

    val dp = LongArray(n.toInt() + 1) { 0L }
    dp[0] = 1L
    aList.forEach { dp[it.toInt()] = -1L }

    for (i in 0..n.toInt() - 2) {
        if (dp[i] == -1L) continue
        if (dp[i + 1] != -1L) dp[i + 1] = (dp[i + 1] + dp[i]) % mod
        if (dp[i + 2] != -1L) dp[i + 2] = (dp[i + 2] + dp[i]) % mod
    }
    if (dp[n.toInt() - 1] != -1L) dp[n.toInt()] = (dp[n.toInt()] + dp[n.toInt() - 1]) % mod
    println(dp[n.toInt()])
}
