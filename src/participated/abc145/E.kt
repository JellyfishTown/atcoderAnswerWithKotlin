package participated.abc145

fun main(args: Array<String>) {
    val (n, t) = readLine()!!.split(' ').map(String::toInt)
    val abArray = Array(n+1) { Pair(0, 0) }
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toInt)
        abArray[it] = Pair(x, y)
    }
    val dp = LongArray(t + 1) { 0L }//dp[i] 総時間がi以下の時の価値の最大値
    val selected = Array(t + 1) { "" }
    (0 until n).forEach {
        val (a, b) = abArray[it]
        for (time in t downTo 0) {//time:sum weight
            if (time - a >= 0) {//現在の品物を採択することが可能か
                if (dp[time] > dp[time - a] + b) {
                    //do nothing
                } else {
                    dp[time] = dp[time - a] + b
                    selected[time] = "$it " + selected[time - a]
                }
            }
        }
    }
    val eatList = selected[t - 1].split(" ").filter { it.isNotEmpty() }.map(String::toInt)
    eatList.forEach { abArray[it] = Pair(0, 0) }
    val max = abArray.maxBy { it.second }?.second ?: 0

    println(dp[t - 1] + max)
}