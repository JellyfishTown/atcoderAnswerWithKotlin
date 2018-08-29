package point300

import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close


fun mainb(args: Array<String>) {
    val (n, a) = readLine()!!.split(' ').map(String::toInt)
    val xList = readLine()!!.split(' ').map(String::toInt)
    val yList = xList.map { it - a }
    val maxX = Math.max(xList.max()!!, a)
    val dp = Array(n) { Array(2 * n * maxX!!) { 0 } }

    for (j in 0 until n) {
        for (t in 0 until 2 * n * maxX!!) {

        }
    }

}

fun main(args: Array<String>) {
    val (n, a) = readLine()!!.split(' ').map(String::toInt)
    val x = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(n + 1) { LongArray(x.max()!! * n + 1) { 0L } }
    dp[0][0] = 1
    for (i in 0 until n)
        for (j in i downTo 0)
            for (k in 0..(x.max()!! * i)) {
                println("i:$i,j:$j,k:$k,dp:${dp[j][k]}")
                dp[j + 1][k + x[i]] += dp[j][k]
            }

    var ans = 0L
    for (i in 1..n)
        ans += dp[i][i * a]
    println(ans)
}
