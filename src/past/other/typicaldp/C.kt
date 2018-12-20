package past.other.typicaldp

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val rList = mutableListOf(0)
    val playerNum = Math.pow(2.toDouble(), k.toDouble()).toInt()
    val battleLog = mutableMapOf<Int, MutableList<Int>>()
    (1..playerNum).forEach {
        rList.add(readLine()!!.toInt())
        battleLog[it] = mutableListOf(it)
    }
    val dp = Array(k + 1) { DoubleArray(playerNum + 1) { 0.0 } }
    (1..playerNum).forEach {
        dp[0][it] = 1.0
    }

    for (stage in 1..k) {
        val segmentSize = Math.pow(2.toDouble(), stage.toDouble()).toInt()
        for (p1 in 1..playerNum) {
            val playerSegment = (p1 + segmentSize - 1) / segmentSize
            val segmentStart = (playerSegment - 1) * segmentSize + 1
            val segmentEnd = segmentStart + segmentSize - 1
            var totalWinRate = 0.0
            for (p2 in segmentStart..segmentEnd) {
                if (battleLog[p1]!!.contains(p2).not()) {
                    battleLog[p1]!!.add(p2)
                    totalWinRate += dp[stage - 1][p2] * calcWinRate(rList[p1], rList[p2])
                }
            }
            dp[stage][p1] = dp[stage - 1][p1] * totalWinRate
        }
    }
    dp[k].filterIndexed { index, d -> index >= 1 }.forEach { println("%.9f".format(it)) }
}

fun calcWinRate(myScore: Int, enemyScore: Int): Double {
    return 1.0 / (1.0 + Math.pow(10.0, (enemyScore - myScore).toDouble() / 400.0))
}