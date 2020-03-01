package participated.abc153

fun main(args: Array<String>) {

    val (h, n) = readLine()!!.split(' ').map(String::toInt)
    val abList = mutableListOf<Pair<Int, Int>>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        abList.add(Pair(a, b))
    }
    abList.sortBy { it.second.toDouble() / it.first.toDouble() }

    var ans = Long.MAX_VALUE / 2
    val dp = LongArray(10001) { Long.MAX_VALUE / 2 }
    for (ab in abList) {
        val (a, b) = ab
        dp[a] = Math.min(dp[a], b.toLong())
        if (a > h) ans = Math.min(ans, b.toLong())
        for (i in 1 until h) {
            if (dp[i] != 0L) {
                if (i + a >= h) ans = Math.min(ans, dp[i] + b.toLong())
                else dp[i + a] = Math.min(dp[i + a], dp[i] + b.toLong())
            }
        }
    }
    println(ans)
}