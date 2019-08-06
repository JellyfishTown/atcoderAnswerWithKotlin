package past.point400

fun main(args: Array<String>) {
    val mod = 1000000007L
    val fib = arrayOf<Long>(1, 2, 3, 5, 8, 13, 21, 34, 55)
    val (h, w, k) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(h + 1) { Array(w) { 0L } }
    dp[0][0] = 1
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (j > 0) {
                dp[i + 1][j - 1] += dp[i][j] * fib[Math.max(0, j - 2)] * fib[Math.max(0, w - j - 2)]
                dp[i + 1][j - 1] %= mod
            }
            dp[i + 1][j] += dp[i][j] * fib[Math.max(0, j - 1)] * fib[Math.max(0, w - j - 2)]
            dp[i + 1][j] %= mod
            if (j < w - 1) {
                dp[i + 1][j + 1] += dp[i][j] * fib[Math.max(0, j - 1)] * fib[Math.max(0, w - j - 3)]
                dp[i + 1][j + 1] %= mod
            }
        }
    }
    println(dp[h][k - 1])
}
