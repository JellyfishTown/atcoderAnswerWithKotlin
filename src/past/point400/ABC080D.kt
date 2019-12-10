package past.point400

import java.util.*

//PriorityQueue
fun main(args: Array<String>) {
    val (n, _c) = readLine()!!.split(' ').map(String::toInt)
    val stcList = mutableListOf<Triple<Int, Int, Int>>()
    (1..n).forEach {
        val (s, t, c) = readLine()!!.split(' ').map(String::toInt)
        stcList.add(Triple(s, t, c))
    }
    stcList.sortBy { it.first }
    val stQueue = ArrayDeque(stcList)
    val curQueue = PriorityQueue<Triple<Int, Int, Int>>(n, Comparator { o1: Triple<Int, Int, Int>?, o2: Triple<Int, Int, Int>? ->
        if (o1!!.second > o2!!.second) 1 else -1
    })
    var ans = 0
    while (stQueue.isNotEmpty()) {
        val pair = stQueue.pop()
        val limit = pair.first
        val tempList = mutableListOf<Triple<Int, Int, Int>>()
        while (curQueue.isNotEmpty() && curQueue.peek().second <= limit) {
            val poll = curQueue.poll()
            if (pair.third != poll.third && poll.second == limit) tempList.add(poll)
        }
        curQueue.add(pair)
        curQueue.addAll(tempList)
        ans = Math.max(ans, curQueue.size)
    }
    println(ans)
}
