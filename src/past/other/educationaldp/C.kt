package past.other.educationaldp

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val input = mutableMapOf<Int, List<Long>>()
    (1..n).forEachIndexed { index, i -> input[index] =  readLine()!!.split(' ').map(String::toLong)}
    val dp = Array(n) { LongArray(3) { 0L } }
    dp[0][0] = input[0]!![0]
    dp[0][1] = input[0]!![1]
    dp[0][2] = input[0]!![2]

    for (i in 1 until n) {
        dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + input[i]!![0]
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + input[i]!![1]
        dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + input[i]!![2]
    }
    println(dp[n-1].max())
}
