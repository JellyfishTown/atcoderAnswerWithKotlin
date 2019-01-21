package past.other.educationaldp

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val t = readLine()!!.toCharArray()
    val dp = Array(s.size + 1) { LongArray(t.size + 1) { 0L } }
    for (i in 0 until s.size) {
        for (j in 0 until t.size) {
            if (s[i] == t[j])
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1)
            dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1])
            dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j])
        }
    }
    var answer = ""
    var i = s.size
    var j = t.size
    while (i > 0 && j > 0) {
        when {
            dp[i][j] == dp[i - 1][j] -> i--
            dp[i][j] == dp[i][j - 1] -> j--
            else -> {
                answer = s[i - 1] + answer
                i--
                j--
            }
        }
    }
    println(answer)
}
