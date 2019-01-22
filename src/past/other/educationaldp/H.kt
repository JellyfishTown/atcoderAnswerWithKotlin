package past.other.educationaldp

fun main(args: Array<String>) {
    val mod = 1000000007L
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val map = mutableListOf(CharArray(w + 1) { ' ' })
    (1..h).forEach { map.add(CharArray(1) { ' ' } + readLine()!!.toCharArray()) }
    val dp = Array(h + 1) { LongArray(w + 1) { 0L } }
    dp[h][w] = 1
    for (th in h downTo 1) {
        for (tw in w downTo 1) {
            if (map[th][tw] == '.') {
                if (map[th - 1][tw] == '.') {
                    dp[th - 1][tw] = (dp[th - 1][tw] + dp[th][tw]) % mod
                }
                if (map[th][tw - 1] == '.') {
                    dp[th][tw - 1] = (dp[th][tw - 1] + dp[th][tw]) % mod
                }
            }
        }
    }
    println(dp[1][1])
}
