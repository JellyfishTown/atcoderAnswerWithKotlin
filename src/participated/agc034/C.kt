package participated.agc034

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(' ').map(String::toLong)
    val bluList = mutableListOf<Triple<Long, Long, Long>>()
    (1..n).forEach {
        val (b, l, u) = readLine()!!.split(' ').map(String::toLong)
        bluList.add(Triple(b, l, u))
    }
    var aokiScore = bluList.map { it.first * it.second }.sum()
    val diffList = bluList.map {  - (it.first) * (it.third - it.second) }
//    val diffList = bluList.map { x * it.third - (it.first) * (it.third - it.second) }
    val diffPair = mutableListOf<Pair<Int, Long>>()
    (0 until n.toInt()).forEach { diffPair.add(Pair(it, diffList[it])) }
    diffPair.sortByDescending { it.second }

    var takahashiScore = 0L

    var ans = 0L
    for ((i, diff) in diffPair) {
        aokiScore += bluList[i].first * (bluList[i].third - bluList[i].second)
        if (aokiScore > takahashiScore + bluList[i].third * x) {
            takahashiScore += bluList[i].third * x
            ans += x
            if (aokiScore == takahashiScore) break
        } else {
            for (j in 1..x) {
                takahashiScore += bluList[i].third
                ans += 1
                if (aokiScore <= takahashiScore) break
            }
            break
        }
    }
    println(ans)
}
