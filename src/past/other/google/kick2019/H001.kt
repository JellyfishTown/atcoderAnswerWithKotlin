package past.other.google.kick2019

import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val citedPaperQueue = PriorityQueue<Int>(Comparator { o1: Int?, o2: Int? -> if (o1!! > o2!!) 1 else -1 })
    for (i in 1..t) {
        print("Case #$i: ")
        val n = readLine()!!.toInt()
        val aList = readLine()!!.split(' ').map(String::toInt)

        var maxH = 1
        citedPaperQueue.clear()
        for (j in 1..n) {
            val a = aList[j - 1]
            citedPaperQueue.add(a)
            while (citedPaperQueue.isNotEmpty()) {
                val minCiteNum = citedPaperQueue.poll()
                if (minCiteNum > maxH) {
                    citedPaperQueue.add(minCiteNum)
                    break
                }
            }
            maxH = Math.max(maxH, citedPaperQueue.size)
            print("$maxH ")
        }
        println()
    }
}
