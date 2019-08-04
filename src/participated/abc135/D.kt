package participated.abc135

fun main(args: Array<String>) {
    val s = readLine()!!
    val n = s.length
    val dp = Array(n + 1) { Array(13) { 0L } }//dp[i][j] i文字目まで見た時の、13で割った余りがjであるものの数
    dp[0][0] = 1L
    for (i in 0 until n) {
        val c = if (s[i] == '?') -1 else s[i].toString().toInt()
        for (j in 0..9) {
            if (c != -1 && c != j) continue//s[i]が?の場合は全ての数字について試し、そうでない場合はその数字のみ試す
            for (ki in 0..12) dp[i + 1][(ki * 10 + j) % 13] += dp[i][ki]
        }
        for (ki in 0..12) dp[i + 1][ki] %= 1000000007L
    }
    println(dp[n][5])
}
