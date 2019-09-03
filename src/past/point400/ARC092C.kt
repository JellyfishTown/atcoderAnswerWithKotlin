fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val usedAb = Array(n) { false }
    val iabList = (0 until n).map {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        Triple(it, a, b)
    }.toMutableList()
    val cdList = (1..n).map {
        val (c, d) = readLine()!!.split(' ').map(String::toInt)
        Pair(c, d)
    }.toMutableList().sortedBy { it.first }

    var ans = 0
    for ((c, d) in cdList) {
        val enableAB = iabList
                .filter { (it.second < c) && (it.third < d) && (usedAb[it.first].not()) }
                .sortedByDescending { it.third }
        if (enableAB.isNotEmpty()) {
            val (i, a, b) = enableAB[0]
            usedAb[i] = true
            ans++
        }
    }
    println(ans)
}