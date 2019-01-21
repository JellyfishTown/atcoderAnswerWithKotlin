package past.other.educationaldp

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(100001) { Long.MAX_VALUE / 2 }
    dp[0] = 0
    for (i in 1..n) {
        val (tw, tv) = readLine()!!.split(' ').map(String::toLong)
        for (sv in 100000 downTo 0)
            if (sv - tv >= 0)
                dp[sv] = Math.min(dp[sv], dp[sv - tv.toInt()] + tw)
        println(dp.indices.indexOfLast { dp[it] <= w })
    }
}
