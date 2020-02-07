package participated.ext014

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xlList = mutableListOf<Pair<Long, Long>>()
    val lrList = mutableListOf<Triple<Long, Long, Long>>()
    (1..n).forEach {
        val (x, l) = readLine()!!.split(' ').map(String::toLong)
        xlList.add(Pair(x, l))
        lrList.add(Triple(x - l, x + l, l))
    }
    xlList.sortBy { it.first }
    lrList.sortBy { it.first }

    if (n == 1) {
        println(1)
        return
    }

    val queue = ArrayDeque(lrList)
    val ansQueue = ArrayDeque<Triple<Long, Long, Long>>()
    var ans = 0
    while (queue.isNotEmpty()) {
        if (queue.size == 1) {
            ans++
            break
        }
        val p1 = queue.pollFirst()
        val p2 = queue.pollFirst()
        if (p1.second > p2.first) {
            //delete
            if (p1.second > p2.second) {
                queue.addFirst(p2)
            } else {
                queue.addFirst(p1)
            }
        } else {
            queue.addFirst(p2)
            ans++
        }
    }
    println(ans)

}