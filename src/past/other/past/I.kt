package past.other.past

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val scList = (1..m).map {
        val (s, c) = readLine()!!.split(' ')
        Pair(s, c.toLong())
    }

    val dp = mutableMapOf<String, Long>()
    dp["N".repeat(n)] = 0
    for (sc in scList) {
        val (s, c) = sc
        dp[s] = Math.min(dp[s] ?: Long.MAX_VALUE, c)
        val keys = dp.keys.toList()
        for (key in keys) {
            val nextkey = (0 until n).map { if (key[it] == 'Y' || s[it] == 'Y') "Y" else "N" }.joinToString("")
            dp[nextkey] = Math.min(dp[nextkey] ?: Long.MAX_VALUE, dp[key]!! + c)
        }
    }

    println(dp["Y".repeat(n)] ?: -1)
}
