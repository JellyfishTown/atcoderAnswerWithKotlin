package participated.abc129

fun main(args: Array<String>) {
    val mod = 1000000007L
    val l = readLine()!!.toCharArray()
    val dp = Array(l.size) { LongArray(2) { 0L } }
    dp[0][0] = 1L
    dp[0][1] = 2L

    for (i in 1 until l.size) {
        dp[i][0] = (dp[i - 1][0] * 3) % mod
        if (l[i] == '1') {
            dp[i][0] = (dp[i][0] + dp[i - 1][1]) % mod
            dp[i][1] = (dp[i - 1][1] * 2) % mod
        } else {
            dp[i][1] = (dp[i - 1][1]) % mod
        }
    }
    println((dp[l.size-1][0]+dp[l.size-1][1])%mod)
}
