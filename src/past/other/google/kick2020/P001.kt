package past.other.google.kick2020


fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 1..t) {
        val (n, k, p) = readLine()!!.split(' ').map(String::toInt)
        val kSumMap = mutableListOf<List<Int>>()
        for (j in 0 until n) {
            val kList = readLine()!!.split(' ').map(String::toInt)
            val kSumList = mutableListOf(kList[0])
            (1 until k).forEach { kSumList.add(kSumList[it - 1] + kList[it]) }
            kSumMap.add(kSumList)
        }

        val dp = Array(p + 100) { Pair(0, -1) } // [cost] = (maxValue,curNnum)

        for (tk in 0 until k) {
            val curP = kSumMap[0][tk]
            val cost = tk + 1
            dp[cost] = Pair(curP, 0)
        }

        for (tn in 1 until n) {
            for (tk in 0 until k) {
                val curP = kSumMap[tn][tk]
                val cost = tk + 1

                for (dpi in p downTo 1) {
                    if (dp[dpi].first != 0) {
                        if (dp[dpi + cost].first < dp[dpi].first + curP && tn != dp[dpi].second) {
                            dp[dpi + cost] = Pair(dp[dpi].first + curP, tk)
                        }
                    }
                }
            }

            for (tk in 0 until k) {
                val curP = kSumMap[tn][tk]
                val cost = tk + 1
                if (dp[cost].first < curP) {
                    dp[cost] = Pair(curP, tk)
                }
            }
        }

        println("Case #$i: ${dp.filterIndexed { index, pair -> index<=p }.maxBy { it.first }!!.first}")
    }
}

