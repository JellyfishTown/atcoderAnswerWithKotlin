package past.point400

import java.util.*

//探索
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val branches = Array(n + 1) { mutableListOf<Pair<Int, Long>>() }
    (1 until n).forEach {
        val (a, b, c) = readLine()!!.split(' ').map(String::toLong)
        branches[a.toInt()].add(Pair(b.toInt(), c))
        branches[b.toInt()].add(Pair(a.toInt(), c))
    }
    val minCost = LongArray(n+1) { Long.MAX_VALUE / 3 }
    val (q, k) = readLine()!!.split(' ').map(String::toLong)

    val queue = ArrayDeque<Int>().apply { this.add(k.toInt()) }
    minCost[k.toInt()] = 0
    while (queue.isNotEmpty()) {
        val cur = queue.pollFirst()!!
        val curCost = minCost[cur]
        val bs = branches[cur]
        for (b in bs) {
            val (to, cost) = b
            if (minCost[to] > curCost + cost) {
                minCost[to] = curCost + cost
                queue.add(to)
            }
        }
    }
    (1..q).forEach {
        val (from, to) = readLine()!!.split(' ').map(String::toInt)
        println(minCost[from] + minCost[to])
    }
}
