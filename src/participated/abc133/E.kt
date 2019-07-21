package participated.abc133

import java.util.*

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val tree = mutableMapOf<Int, MutableList<Int>>()
    val visited = Array(n + 1) { false }
    (1..n).forEach { tree[it] = mutableListOf() }
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        tree[a]!!.add(b)
        tree[b]!!.add(a)
    }
    val d1num = Array(n + 1) { 0 }
    val d2num = Array(n + 1) { 0 }

    val queue = ArrayDeque<Int>()
    queue.add(1)
    val ansList = mutableListOf<Long>()
    while (queue.isNotEmpty()) {
        val i = queue.pollFirst()!!
        visited[i] = true
        val dists = tree[i]!!
        ansList.add((k - d1num[i] - d2num[i]).toLong())
        var count = 0
        for (j in 0 until dists.size) {
            val dist = dists[j]
            if (visited[dist]) continue
            d2num[dist] = count++ + d1num[i]
            d1num[dist] = 1
            queue.add(dist)
        }
    }

    var ans = 1L
    ansList.forEach { ans = (ans * it) % 1000000007 }
    println(ans)
}
