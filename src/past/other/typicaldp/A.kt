package past.other.typicaldp

    fun main(args: Array<String>) {
        val n = readLine()!!.toInt()
        val pList = readLine()!!.split(' ').map(String::toInt)
        val dp = Array(10101) { false }
        dp[0] = true
        for (i in 0 until n)
            for (j in 10000 downTo 0)
                if (!dp[j + pList[i]])
                    dp[j + pList[i]] = dp[j]
        println(dp.count { it })
    }
