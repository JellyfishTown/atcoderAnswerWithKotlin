package past.other.educationaldp

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(w + 1) { 0L }//dp[i] 総重量がi以下の時の価値の最大値
    (1..n).forEach {
        val (tw, v) = readLine()!!.split(' ').map(String::toLong)
        for (sw in w downTo 0) {
            if (sw - tw >= 0) {
                dp[sw] = Math.max(dp[sw], dp[sw - tw.toInt()] + v)
            }
        }
    }
    println(dp[w])
}
