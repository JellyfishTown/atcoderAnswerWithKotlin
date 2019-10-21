package past.other.internal.m4

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    val inQueue = ArrayDeque(aList)

    val ansQueue = ArrayDeque<Long>().apply { this.add(inQueue.removeFirst()) }
    var getFromBigger = true
    while (inQueue.size > 1) {
        if (getFromBigger) {
            ansQueue.addFirst(inQueue.removeLast())
            if (inQueue.size == 1) break
            ansQueue.addLast(inQueue.removeLast())
        } else {
            ansQueue.addFirst(inQueue.removeFirst())
            if (inQueue.size == 1) break
            ansQueue.addLast(inQueue.removeFirst())
        }
        getFromBigger = getFromBigger.not()
    }

    ansQueue.addFirst(inQueue.removeFirst())
    val ansList1 = ansQueue.toList()
    ansQueue.addLast(ansQueue.removeFirst())
    val ansList2 = ansQueue.toList()
    val ans1 = (1 until n).map { Math.abs(ansList1[it] - ansList1[it - 1]) }.sum()
    val ans2 = (1 until n).map { Math.abs(ansList2[it] - ansList2[it - 1]) }.sum()

    println(Math.max(ans1, ans2))
}