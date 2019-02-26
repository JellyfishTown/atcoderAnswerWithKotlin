package past.other.educationaldp

fun main(args: Array<String>) {
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

