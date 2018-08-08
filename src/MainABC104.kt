fun main(args: Array<String>) {
    val s = readLine()!!
    val dp = Array(s.length + 1) { arrayOfNulls<Long>(4) }
    val mod = 1000000007

    dp[s.length][0] = 0
    dp[s.length][1] = 0
    dp[s.length][2] = 0
    dp[s.length][3] = 1

    for (i in (s.length - 1) downTo 0) {
        val m1 = if (s[i] == '?') 3 else 1
        dp[i][3] = ((dp[i + 1][3]!!) % mod * m1) % mod

        for (j in 2 downTo 0) {
            val m2 = if (s[i] == '?' || s[i] == "ABC"[j]) 1 else 0
            dp[i][j] = (((dp[i + 1][j]!!) % mod * m1) % mod + dp[i + 1][j + 1]!! * m2) % mod
        }
    }
    println(dp[0][0])
}
// fun main(args: Array<String>) {
//    val (dt, g) = readLine()!!.split(' ').map(String::toLong)
//    val d = dt.toInt()
//    val pArray = Array(d + 1) { arrayOfNulls<Long>(101) }
//    val scoreArray = Array<Long?>(1001) { null }
//    scoreArray[0] = 0L
//    for (i in 1..d) {
//        val (p, c) = readLine()!!.split(' ').map(String::toLong)
//        for (j in 1..p.toInt()) {
//            pArray[i][j] = (i.toLong() * 100) * j
//            if (j == p.toInt()) pArray[i][j] = pArray[i][j]!! + c
//        }
//    }
//
//    for (i in 1..d) {
//        var selectNum = 1
//        val scoreArrayBefore = scoreArray.copyOf()
//        while (selectNum != 101 && pArray[i][selectNum] != null) {
//            for (k in 1..1000) {
//                if (selectNum > k) continue
//                val value = scoreArrayBefore[k - selectNum] ?: break
//                if (scoreArray[k] == null ||
//                        scoreArrayBefore[k] ?: 0 < (value + pArray[i][selectNum]!!)) {
//                    scoreArray[k] = value + pArray[i][selectNum]!!
//                }
//                if (scoreArray[k] ?: 0 >= g) break
//            }
//            selectNum++
//        }
//    }
//    for (i in 1..1000) {
//        if (scoreArray[i] ?: 0 >= g) {
//            println(i)
//            break
//        }
//    }
//}

//fun main(args: Array<String>) {
//    val s = readLine()!!
//    println(if (s.startsWith("A") && s.substring(2, s.length - 1).count { it == 'C' } == 1 && s.count { it.isLowerCase() } == s.length - 2) {
//        "AC"
//    } else {
//        "WA"
//    })
//}


//fun main(args: Array<String>) {
//    val r = readLine()!!.toInt()
//    when {
//        r < 1200 -> println("ABC")
//        r < 2800 -> println("ARC")
//        else -> println("AGC")
//    }
//}
