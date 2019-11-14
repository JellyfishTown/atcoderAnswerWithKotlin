package participated.ext012

import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val lrcList = mutableListOf<Triple<Long, Long, Long>>()
    (1..m).forEach {
        val (l, r, c) = readLine()!!.split(' ').map(String::toLong)
        lrcList.add(Triple(l, r, c))
    }

    val branches = mutableMapOf<Long, MutableList<Pair<Long, Long>>>()
    (1..n).forEach { branches[it] = mutableListOf() }
    (1 until n).forEach { branches[it + 1]!!.add(Pair(it, 0)) }
    lrcList.forEach {
        branches[it.first]!!.add(Pair(it.second, it.third))
    }

    val queue = PriorityQueue<Pair<Long, Long>>(n.toInt(), Comparator { o1: Pair<Long, Long>?, o2: Pair<Long, Long>? ->
        if (o1!!.second > o2!!.second) 1 else -1
    })
    queue.add(Pair(1, 0))

    val minCost = Array(n.toInt() + 1) { Long.MAX_VALUE / 2 }
    minCost[1] = 0
    while (queue.isNotEmpty()) {
        val (cur, curCost) = queue.poll()
        val tos = branches[cur]!!
        for (branch in tos) {
            val (to, cost) = branch
            val nextCost = curCost + cost
            if (minCost[to.toInt()] > nextCost) {
                minCost[to.toInt()] = nextCost
                queue.add(Pair(to, nextCost))
            }
        }
    }

    val goalCost = minCost[n.toInt()]
    if (goalCost >= Long.MAX_VALUE / 2) {
        println(-1)
    } else {
        println(goalCost)
    }
}
