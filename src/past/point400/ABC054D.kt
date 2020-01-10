package past.point400

//DP
fun main(args: Array<String>) {
    val (n, ma, mb) = readLine()!!.split(' ').map(String::toInt)
    val abcList =
            (1..n).map {
                val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
                Triple(a, b, c)
            }
    val totalA = abcList.map { it.first }.sum()
    val totalB = abcList.map { it.second }.sum()
    val okList = mutableListOf<Pair<Int, Int>>()
    var i = 1
    while (true) {
        if (i * ma > totalA || i * mb > totalB) break
        okList.add(Pair(i * ma, i * mb))
        i++
    }

    val dp = Array(501) { IntArray(501) { Int.MAX_VALUE } }
    for (abc in abcList) {
        val (a, b, c) = abc
        for (j in 1..400) {
            for (k in 1..400) {
                if (dp[j][k] < Int.MAX_VALUE) {
                    dp[a + j][b + k] = Math.min(dp[a + j][b + k], dp[j][k] + c)
                }
            }
        }
        dp[a][b] = Math.min(dp[a][b], c)
    }

    var ans = Int.MAX_VALUE
    for (ok in okList) {
        val (a, b) = ok
        ans = Math.min(ans, dp[a][b])
    }
    if (ans >= 5000) {
        println(-1)
    } else {
        println(ans)
    }
}

