package past.other.internal.m3

import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val route = Array(n + 1) { mutableSetOf<Int>() }
    (1..m).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        route[a].add(b)
        route[b].add(a)
    }
    val canGoEven = Array(n + 1) { Pair(false, Int.MAX_VALUE) }
    val canGoOdd = Array(n + 1) { Pair(false, Int.MAX_VALUE) }

    val queue = ArrayDeque<Triple<Int, Boolean, Int>>()
    queue.add(Triple(1, true, 0))
    while (queue.isNotEmpty()) {
        val (cur, isEven, dist) = queue.pop()
        if (isEven) {
            val (b, oldDist) = canGoEven[cur]
            if (oldDist > dist) {
                canGoEven[cur] = Pair(true, dist)
                for (to in route[cur]) {
                    queue.add(Triple(to, !isEven, dist + 1))
                }
            }
        } else {
            val (b, oldDist) = canGoOdd[cur]
            if (oldDist > dist) {
                canGoOdd[cur] = Pair(true, dist)
                for (to in route[cur]) {
                    queue.add(Triple(to, !isEven, dist + 1))
                }
            }
        }
    }
    if (canGoEven[n].first) {
        println(canGoEven[n].second / 2)
    } else {
        println(-1)
    }
}