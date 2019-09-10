package participated.abc106

fun main(args: Array<String>) {
    val (n, m, q) = readLine()!!.split(' ').map(String::toInt)
    val railMap = Array(n + 1) { Array(n + 1) { 0 } }
    repeat(m) {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        railMap[l][r] = railMap[l][r] + 1
    }

    val cumSum = Array(n + 1) { Array(n + 1) { 0 } }
    for (i in 1..n) {
        for (j in 1..n) {
            cumSum[i][j] = railMap[i][j] + cumSum[i][j - 1] + cumSum[i - 1][j] - cumSum[i - 1][j - 1]
        }
    }

    repeat(q) {
        val (pi, qi) = readLine()!!.split(' ').map(String::toInt)
        println(cumSum[qi][qi] - cumSum[pi - 1][qi] - cumSum[qi][pi - 1] + cumSum[pi - 1][pi - 1])
    }
}
