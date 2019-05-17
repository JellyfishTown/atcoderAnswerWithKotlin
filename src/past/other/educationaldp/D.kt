package past.other.educationaldp

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(n + 1) { Array(w + 1) { 0L } }//dp[i][wi] i個目までの商品を選べる状況において総重量がwi以下の時の価値の最大値
    (0 until n).forEach {
        val (tw, v) = readLine()!!.split(' ').map(String::toLong)//tw:temporal weight
        for (sw in 0..w) {//sw:sum weight
            if (sw - tw >= 0) {//現在の品物を採択する場合
                dp[it + 1][sw] = Math.max(
                        dp[it + 1][sw]
                        , dp[it][sw - tw.toInt()] + v)
            } else {
                dp[it + 1][sw] = Math.max(
                        dp[it + 1][sw]
                        , dp[it][sw])
            }
        }
    }
    println(dp[n][w])
}


fun main2(args: Array<String>) {
    val (n, w) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(w + 1) { 0L }//dp[i] 総重量がi以下の時の価値の最大値
    (1..n).forEach {
        val (tw, v) = readLine()!!.split(' ').map(String::toLong)//tw:temporal weight
        for (sw in w downTo 0) {//sw:sum weight
            if (sw - tw >= 0) {//現在の品物を採択することが可能か
                dp[sw] = Math.max(
                        dp[sw]//採択しない場合の総重量swの際の価値
                        , dp[sw - tw.toInt()] + v)//採択する場合の総重量swの際の価値
            }
        }
    }
    println(dp[w])
}
