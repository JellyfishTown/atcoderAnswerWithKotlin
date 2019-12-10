package past.point400

//ワーシャルフロイド  最短経路
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val minCost = Array(n + 1) { Array(n + 1) { Long.MAX_VALUE / 10 } }
    (1..n).forEach { minCost[it][it] = 0 }
    val branches = (1..m).map {
        val (a, b, c) = readLine()!!.split(" ").map(String::toInt)
        minCost[a][b] = c.toLong()
        minCost[b][a] = c.toLong()
        Triple(a, b, c)
    }
    for (j in 1..n)
        for (i in 1..n)
            for (k in 1..n)
                minCost[i][k] = Math.min(minCost[i][k], minCost[i][j] + minCost[j][k])

    println(branches.filter { minCost[it.first][it.second] < it.third.toLong() }.size)
}

