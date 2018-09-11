package past.point300

fun main(args: Array<String>) {
    val (n, a) = readLine()!!.split(' ').map(String::toInt)
    val x = readLine()!!.split(' ').map(String::toInt)
    val max = x.max()!!
    val dp = Array(n + 1) { LongArray(max * n + 1) { 0L } }
    dp[0][0] = 1
    for (i in 0 until n)
        for (j in i downTo 0)
            for (k in 0..(max * i)) {
//                println("i:$i,j:$j,k:$k,dp:${dp[j][k]}")
                dp[j + 1][k + x[i]] += dp[j][k]
            }

    var ans = 0L
    for (i in 1..n)
        ans += dp[i][i * a]
    println(ans)
}
