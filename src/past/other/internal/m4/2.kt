package past.other.internal.m4

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    val inQueue = ArrayDeque<Long>()
    aList.forEach { inQueue.add(it) }

    val ansQueue = ArrayDeque<Long>()
    ansQueue.add(inQueue.removeFirst())
    var getFromLast = true
    while (inQueue.isNotEmpty()) {
        if (getFromLast) {
            ansQueue.addFirst(inQueue.removeLast())
            if (inQueue.isEmpty()) break
            ansQueue.addLast(inQueue.removeLast())
        } else {
            ansQueue.addFirst(inQueue.removeFirst())
            if (inQueue.isEmpty()) break
            ansQueue.addLast(inQueue.removeFirst())
        }
        getFromLast = !getFromLast
    }

    var ansList = ansQueue.toList()
    var ans = (1 until n).map { Math.abs(ansList[it] - ansList[it - 1]) }.sum()

    aList.forEach { inQueue.add(it) }
    ansQueue.clear()
    ansQueue.add(inQueue.removeLast())
    getFromLast = false
    while (inQueue.isNotEmpty()) {
        if (getFromLast) {
            ansQueue.addFirst(inQueue.removeLast())
            if (inQueue.isEmpty()) break
            ansQueue.addLast(inQueue.removeLast())
        } else {
            ansQueue.addFirst(inQueue.removeFirst())
            if (inQueue.isEmpty()) break
            ansQueue.addLast(inQueue.removeFirst())
        }
        getFromLast = !getFromLast
    }

    ansList = ansQueue.toList()
    ans = Math.max(ans, (1 until n).map { Math.abs(ansList[it] - ansList[it - 1]) }.sum())
    println(ans)
}