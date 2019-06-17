package participated.ext010

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xyList = mutableListOf<Pair<Long, Long>>()
    val diffList = mutableListOf<Pair<Long, Long>>()
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toLong)
        xyList.add(Pair(x, y))
    }
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            diffList.add(Pair(xyList[i].first - xyList[j].first, xyList[i].second - xyList[j].second))
            diffList.add(Pair(-xyList[i].first + xyList[j].first, -xyList[i].second + xyList[j].second))
        }
    }
    diffList.sortBy { it.second }
    diffList.sortBy { it.first }
    var sameCount = 1L
    var minCost = 0L
    for (i in 1 until diffList.size) {
        val (bdx, bdy) = diffList[i - 1]
        val (dx, dy) = diffList[i]
        if (dx == 0L && dy == 0L) {
            minCost = Math.max(minCost, sameCount)
            sameCount = 1
            continue
        }
        if (bdx == dx && bdy == dy) {
            sameCount++
        } else {
            minCost = Math.max(minCost, sameCount)
            sameCount = 1
        }
    }
    println(n - minCost)
}
