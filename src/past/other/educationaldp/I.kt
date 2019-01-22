package past.other.educationaldp

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(' ').map(String::toDouble)
    val dp = Array(n + 1) { DoubleArray(n + 1) { 0.0 } }
    dp[0][0]= 1.0
    for (r in 0 until n) {
        for (c in 0..r) {
            dp[r + 1][c] += dp[r][c] * (1 - p[r])
            dp[r + 1][c + 1] += dp[r][c] * p[r]
        }
    }
    println(dp[n].filterIndexed { index, d -> index > n / 2 }.sum())
}
