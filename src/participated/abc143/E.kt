package participated.abc143

fun main(args: Array<String>) {
    val (n, m, l) = readLine()!!.split(' ').map(String::toInt)
    val minCostMap = Array(n + 1) { Array(n + 1) { Long.MAX_VALUE / 2 } }
    (1..n).forEach {
        minCostMap[it][it] = 0
    }
    for (i in 0 until m) {
        val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
        minCostMap[a][b] = c.toLong()
        minCostMap[b][a] = c.toLong()
    }
    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                minCostMap[j][k] = Math.min(minCostMap[j][k], minCostMap[j][i] + minCostMap[i][k])
            }
        }
    }

    val minSupMap = Array(n + 1) { Array(n + 1) { Long.MAX_VALUE / 2 } }
    (1..n).forEach { minSupMap[it][it] = 0 }
    for (i in 1 until n) {
        for (j in i + 1..n) {
            if (minCostMap[i][j] <= l) {
                minSupMap[i][j] = 1
                minSupMap[j][i] = 1
            }
        }
    }
    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                minSupMap[j][k] = Math.min(minSupMap[j][k], minSupMap[j][i] + minSupMap[i][k])
            }
        }
    }
    for (x in 1..(readLine()!!.toInt())) {
        val (s, t) = readLine()!!.split(' ').map(String::toInt)
        val sup = minSupMap[s][t] - 1
        println(if (sup > Long.MAX_VALUE / 10) -1 else sup)
    }
}