package participated.abc147

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val aMap = Array(h) { readLine()!!.split(' ').map(String::toLong).toLongArray() }
    val bMap = Array(h) { readLine()!!.split(' ').map(String::toLong).toLongArray() }
    val diffMap = Array(h) { IntArray(w) }
    for (r in 0 until h) {
        for (c in 0 until w) {
            diffMap[r][c] = Math.abs(aMap[r][c] - bMap[r][c]).toInt()
        }
    }

    val size = (h + w) * 80
    val dp =
            Array(h) {
                Array(w) {
                    BooleanArray(size) { false }
                }
            }
    dp[0][0][Math.abs(aMap[0][0] - bMap[0][0]).toInt()] = true
    for (r in 0 until h) {
        for (c in 0 until w) {
            val diff = diffMap[r][c]
            for (i in 0 until size) {
                val minus = Math.abs(i - diff)
                val plus = i + diff
                if (r - 1 >= 0 && dp[r - 1][c][i]) {
                    if (dp[r][c].size > plus) dp[r][c][plus] = true
                    dp[r][c][minus] = true
                } else if (c - 1 >= 0 && dp[r][c - 1][i]) {
                    if (dp[r][c].size > plus) dp[r][c][plus] = true
                    dp[r][c][minus] = true
                }
            }
        }
    }

    val min = dp[h - 1][w - 1].indexOfFirst { it }
    println(min)
}
