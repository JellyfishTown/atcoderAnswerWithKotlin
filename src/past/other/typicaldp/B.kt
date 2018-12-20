package past.other.typicaldp

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt).reversed()
    val bList = readLine()!!.split(' ').map(String::toInt).reversed()
    val dp = Array(a + 1) { LongArray(b + 1) { 0 } }

    (1..a).forEach { dp[it][0] =dp[it - 1][0] + (a + b + it + 1) % 2 * aList[it - 1] }
    (1..b).forEach { dp[0][it] =dp[0][it - 1] + (a + b + it + 1) % 2 * bList[it - 1] }

    for (i in 1..a) {
        for (j in 1..b) {
            dp[i][j] = if ((a + b + i + j + 1) % 2 == 1) {
                Math.max(dp[i - 1][j] + aList[i - 1], dp[i][j - 1] + bList[j - 1])
            } else {
                Math.min(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[a][b])
}
