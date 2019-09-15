package participated.abc141

import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val queue = PriorityQueue<Long>(n, Comparator { o1: Long?, o2: Long? -> if (o1!! > o2!!) -1 else 1 })
    aList.forEach { queue.add(it) }
    for (i in 1..m) {
        val max = queue.poll()
        val ins = max / 2
        queue.add(ins)
    }
    println(queue.sum())
}