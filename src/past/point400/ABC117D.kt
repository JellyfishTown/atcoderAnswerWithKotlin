package past.point400

fun main(args: Array<String>) {
    fun max(vararg v: Long): Long = v.max()!!
    val digits = 41

    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)

    val dp = Array(digits + 1) { Array(2) { -1L } }//dp[digits][未満フラグ] = 最大値
    dp[digits][0] = 0L

    for (d in (digits - 1) downTo 0) {
        val mask = 1L shl d
        val count1 = aList.count { a -> (a and mask) != 0L }
        val x0score = count1 * mask//d桁目を0にした場合の、その桁から得られるスコア
        val x1score = (n - count1) * mask

        //フリー⇒フリー
        if (dp[d + 1][1] >= 0)
            dp[d][1] = max(dp[d][1], dp[d + 1][1] + x0score, dp[d + 1][1] + x1score)

        //フリーじゃない⇒フリー
        if (dp[d + 1][0] >= 0)
            if (k and mask != 0L)
                dp[d][1] = max(dp[d][1], dp[d + 1][0] + x0score)

        //フリーじゃない⇒フリーじゃない
        if (dp[d + 1][0] >= 0)
            if (k and mask != 0L)
                dp[d][0] = max(dp[d][0], dp[d + 1][0] + x1score)
            else
                dp[d][0] = max(dp[d][0], dp[d + 1][0] + x0score)

    }
    println(max(dp[0][0], dp[0][1]))
}
