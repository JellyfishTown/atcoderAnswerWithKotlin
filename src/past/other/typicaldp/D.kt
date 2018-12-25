package past.other.typicaldp

fun main(args: Array<String>) {
    val (n, d) = readLine()!!.split(' ').map(String::toLong)
    val dPrimes = Array(6) { 0 }
    var tempD = d
    while (tempD % 2 == 0L) {
        dPrimes[2]++; tempD /= 2
    }
    while (tempD % 3 == 0L) {
        dPrimes[3]++; tempD /= 3
    }
    while (tempD % 5 == 0L) {
        dPrimes[5]++; tempD /= 5
    }
    if (tempD > 1) {
        println(0.0)
        return
    }

    val dp = //dp[n][x][y][z]
            Array(n.toInt() + 1) {
                Array(dPrimes[2] + 1) {
                    Array(dPrimes[3] + 1) {
                        DoubleArray(dPrimes[5] + 1) { 0.0 }
                    }
                }
            }
    dp[0][0][0][0] = 1.0
    for (i in 1..n.toInt()) {
        for (x in 0..dPrimes[2]) {
            for (y in 0..dPrimes[3]) {
                for (z in 0..dPrimes[5]) {
                    dp[i][x][y][z] += dp[i - 1][x][y][z] / 6.0
                    dp[i][Math.min(x + 1, dPrimes[2])][y][z] += dp[i - 1][x][y][z] / 6.0
                    dp[i][x][Math.min(y + 1, dPrimes[3])][z] += dp[i - 1][x][y][z] / 6.0
                    dp[i][Math.min(x + 2, dPrimes[2])][y][z] += dp[i - 1][x][y][z] / 6.0
                    dp[i][x][y][Math.min(z + 1, dPrimes[5])] += dp[i - 1][x][y][z] / 6.0
                    dp[i][Math.min(x + 1, dPrimes[2])][Math.min(y + 1, dPrimes[3])][z] += dp[i - 1][x][y][z] / 6.0
                }
            }
        }
    }
    println(dp[n.toInt()][dPrimes[2]][dPrimes[3]][dPrimes[5]])
}
