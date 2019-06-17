package participated.ext010

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted().toMutableList()

    val pat = aList.toSet().size
    if (pat == 1) {
        println(aList[0] * (n - 2))
        while (true) {
            if (aList.size != 2) {
                println("${aList[aList.size - 1]} ${aList[aList.size - 2]}")
                val diff = aList[aList.size - 1] - aList[aList.size - 2]
                aList.removeAt(aList.size - 1)
                aList.removeAt(aList.size - 1)
                aList.add(diff)
            } else {
                println("${aList[aList.size - 2]} ${aList[aList.size - 1]}")
                return
            }
        }
    }

    val allP = aList.all { it >= 0 }
    val allM = aList.all { it <= 0 }
    val pQueue = PriorityQueue<Long>()
    val mQueue = PriorityQueue<Long>()
    var l = 0L
    var r = 0L
    if (allP) {
        val temp = aList.first() - aList.last()
        l = aList.removeAt(0)
        r = aList.removeAt(aList.size - 1)
        aList.add(temp)
    }
    if (allM) {
        val temp = aList.last() - aList.first()
        l = aList.removeAt(aList.size - 1)
        r = aList.removeAt(0)
        aList.add(temp)
    }

    println(aList.map { Math.abs(it) }.sum())
    if(allP || allM)println("$l $r")
    aList.forEach {
        if (it > 0) pQueue.add(it)
        else if (it <= 0) mQueue.add(it)
    }
    while (true) {
        if (pQueue.size == 1 && mQueue.size == 1) {
            println("${pQueue.poll()} ${mQueue.poll()}")
            return
        } else {
            val p = pQueue.poll()
            val m = mQueue.poll()
            if (pQueue.size == 0) {
                println("$p $m")
                pQueue.add(p - m)
            } else {
                println("$m $p")
                mQueue.add(m - p)
            }
        }
    }
}
