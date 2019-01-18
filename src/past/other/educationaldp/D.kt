package past.other.educationaldp

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(w + 1) { 0L }
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
//    val dp = mutableMapOf<Long, Pair<Long, Long>>()//w,n,v
//    dp[0L] = Pair(0L, 0L)
//    for (ni in 0 until n) {
//        val tempDp = mutableMapOf<Long, Pair<Long, Long>>()//w,n,v
//        for (temp in dp) {
//            if (temp.key + wList[ni] <= w) {
//                if (dp[temp.key]!!.second < temp.value.second + vList[ni]) {
//                    tempDp[temp.key + wList[ni]] = Pair(temp.value.first + 1, temp.value.second + vList[ni])
//                }
//            }
//        }
//        dp.putAll(tempDp)
//    }
//    println(dp.maxBy { it.value.second }!!.value.second)
//    val dp = Array(n + 2) { LongArray(w + 2) { 0L } }
//
//    for (ni in 0 until n) {
//        for (selected in ni downTo 0) {
//            if (selected == 0) {
//                dp[1][wList[ni]] = Math.max(dp[1][wList[ni]], vList[ni])
//                break
//            }
//            for (weight in w downTo 0) {
//                val totalW = weight + wList[ni]
//                if ((dp[selected][weight] != 0L) && (totalW <= w)) {
//                    dp[selected + 1][totalW] =
//                            Math.max(dp[selected + 1][totalW], dp[selected][weight] + vList[ni])
//                }
//
//            }
//        }
//
//    }
//    println(dp.map { it.max()!! }.max())

