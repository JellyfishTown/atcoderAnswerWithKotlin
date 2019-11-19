package past.point400

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val branch = Array(n + 1) { mutableListOf<Int>() }
    val minDist = Array(n + 1) { Int.MAX_VALUE / 2 }
    val froms = Array(n + 1) { 0 }
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        branch[a].add(b)
        branch[b].add(a)
    }
    val queue = ArrayDeque<Int>()
    queue.add(1)
    minDist[1] = 0
    while (queue.isNotEmpty()) {
        val cur = queue.pollFirst()!!
        val bs = branch[cur]
        for (to in bs) {
            if (minDist[to] > minDist[cur] + 1) {
                queue.add(to)
                minDist[to] = minDist[cur] + 1
                froms[to] = cur
            }
        }
    }
    var cut = n
    for (i in 1 until (minDist[n] + 1) / 2) {
        cut = froms[cut]
    }
    branch[cut].remove(froms[cut])
    branch[froms[cut]].remove(cut)

    (1..n).forEach { minDist[it] = Int.MAX_VALUE / 2 }
    queue.add(1)
    minDist[1] = 0
    var count = 1
    while (queue.isNotEmpty()) {
        val cur = queue.pollFirst()!!
        val bs = branch[cur]
        for (to in bs) {
            if (minDist[to] > minDist[cur] + 1) {
                queue.add(to)
                minDist[to] = minDist[cur] + 1
                froms[to] = cur
                count++
            }
        }
    }
    if (count * 2 > n) {
        println("Fennec")
    } else {
        println("Snuke")
    }
}
