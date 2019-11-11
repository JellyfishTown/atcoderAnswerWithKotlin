package participated.ext012

import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val lrcList = mutableListOf<Triple<Long, Long, Long>>()
    (1..m).forEach {
        val (l, r, c) = readLine()!!.split(' ').map(String::toLong)
        lrcList.add(Triple(l, r, c))
    }
    lrcList.sortBy { it.third }
    lrcList.sortBy { it.first }
    val lrcG = lrcList.groupBy { it.first }

    val minDist = Array(n.toInt() + 1) { Long.MAX_VALUE / 2 }
    minDist[1] = 0
    var cur = 1L
    while (cur < n) {
        if (lrcG.containsKey(cur).not()) continue
        val branches = lrcG[cur]!!
        var rMax = branches[0].first
        for (branch in branches) {
            val (l, r, c) = branch
            for (next in (rMax + 1)..r) {
                val nextDist = minDist[cur.toInt()] + c
                if (minDist[next.toInt()] > nextDist) {
                    minDist[next.toInt()] = nextDist
                }
            }
            rMax = Math.max(rMax, r)
        }
        val filtered = lrcG.filterKeys { it in (cur + 1)..rMax }
        if (filtered.isEmpty()) break
        val (next, list) = filtered.minBy { it.value[0].third }!!
        cur = next
    }

    if (minDist[n.toInt()] > Long.MAX_VALUE / 3) {
        println(-1)
    } else {
        println(minDist[n.toInt()])
    }
}