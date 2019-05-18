package past.point400

//参考https://atcoder.jp/contests/abc122/submissions/4700029
fun main(args: Array<String>) {
    //(T,A,G,C) = (0, 1, 2, 3)
    val mod = (1e9 + 7).toLong()
    val n = readLine()!!.toInt()

    //dp[i][3文字前][2文字前][1文字前]
    val dp = Array(n + 1) { Array(4) { Array(4) { LongArray(4) { 0L } } } }
    dp[0][0][0][0] = 1L
    for (i in 0 until n) for (a in 0..3) for (b in 0..3) for (c in 0..3) for (d in 0..3) {

        // 3文字NGパターン AGC, GAC, ACG
        if (isNg(b, c, d) || isNg(c, b, d) || isNg(b, d, c)) continue
        // 4文字NGパターン AXGC, AGXC
        if (isNg(a, c, d) || isNg(a, b, d)) continue

        // NGパターンがなければ遷移先に足す
        dp[i + 1][b][c][d] = (dp[i + 1][b][c][d] + dp[i][a][b][c]) % mod
    }
    var sum = 0L
    for (a in 0..3) for (b in 0..3) for (c in 0..3) {
        sum = (sum + dp[n][a][b][c]) % mod
    }
    println(sum)
}

fun isNg(a: Int, b: Int, c: Int): Boolean {
    return (a == 1 && b == 2 && c == 3)
}
