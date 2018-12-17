package past.point300

fun main(args: Array<String>) {
    val (n, a) = readLine()!!.split(' ').map(String::toInt)
    val x = readLine()!!.split(' ').map(String::toInt)
    val max = x.max()!!
    val dp = Array(n + 1) { LongArray(max * n + 1) { 0L } }
    dp[0][0] = 1
    for (i in 0 until n)//カードを1枚ずつループ
        for (j in i downTo 0)//そのカードを1枚目に選ぶとき、2枚目に選ぶとき、3枚目に選ぶときをループ
            for (k in 0..(max * i)) {//パターンを配るループ
//                println("i:$i,j:$j,k:$k,dp:${dp[j][k]}")
                dp[j + 1][k + x[i]] += dp[j][k]
            }

    var ans = 0L
    for (i in 1..n)
        ans += dp[i][i * a]
    println(ans)
}
