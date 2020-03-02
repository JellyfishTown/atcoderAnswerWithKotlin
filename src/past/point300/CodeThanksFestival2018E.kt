package past.point300

fun main(args: Array<String>) {
    val mod = 1000000007L
    val numMax = 600 //同じ数字は黒板上に高々600個までしか存在しないため
    val twoPowList = arrayOf(0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512)

    val t = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList().apply { this.add(0, 0) }

    val dp = Array(t + 2) { LongArray(numMax + 1) { 0L } }//dp[t][count] 数字tが黒板上にcount個並ぶような組み合わせ数
    for (curNum in 1..t) {
        val canUseCount = aList[curNum]
        dp[curNum][0] += dp[curNum - 1][0]
        dp[curNum][0] += dp[curNum - 1][1]
        dp[curNum][0] %= mod
        for (i in 1..canUseCount) dp[curNum][i]++

        for (i in 2..numMax step 2) {
            for (innerCount in 0..canUseCount) {
                dp[curNum][i / 2 + innerCount] += dp[curNum - 1][i]
                dp[curNum][i / 2 + innerCount] %= mod
            }
        }
    }
    println(dp[t].filterIndexed { index, l -> twoPowList.contains(index) }.sum() % mod)
}
