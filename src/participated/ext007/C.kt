package participated.ext007

//https://atcoder.jp/contests/tenka1-2019
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    var ans = s.count { it == '.' }
    ans = Math.min(ans, s.count { it == '#' })
    val blackCount = Array(n) { 0 }
    blackCount[0] = if (s[0] == '#') 1 else 0
    (1 until n).forEach { blackCount[it] = blackCount[it - 1] + if (s[it] == '#') 1 else 0 }

    val whiteCount = Array(n) { 0 }
    whiteCount[n - 1] = if (s[n - 1] == '.') 1 else 0
    (n - 2 downTo 0).forEach { whiteCount[it] = whiteCount[it + 1] + if (s[it] == '.') 1 else 0 }

    for (i in 0 until (n - 1)) {
        val white = blackCount[i]
        val black = whiteCount[i + 1]
        ans = Math.min(ans, white + black)
    }
    println(ans)
}
