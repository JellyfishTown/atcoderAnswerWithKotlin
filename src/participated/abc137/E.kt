package participated.abc137

import java.util.*

fun main(args: Array<String>) {
    data class Abc(val n: Int, val to: MutableMap<Int, Int> = mutableMapOf(), var score: Long = 0L, var visited: Boolean = false)

    val (n, m, p) = readLine()!!.split(' ').map(String::toInt)
    val pointList = mutableListOf<Abc>()
    (0..n).forEach { pointList.add(Abc(it)) }
    (1..m).forEach {
        val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
        pointList[a].to[b] = -(c - p)
    }

    val queue = ArrayDeque<Int>()
    queue.add(1)
    while (queue.isNotEmpty()) {
        val point = pointList[queue.pollFirst()]
        point.visited = true

        for ((to, coin) in point.to) {
            val toPoint = pointList[to]
            if (toPoint.visited && point.score + coin > toPoint.score) {
                println(-1)
                return
            }else if (toPoint.visited){
                //do nothing
            }else{
                toPoint.score = Math.max(toPoint.score, point.score + coin)
                queue.add(to)
            }
        }
    }
    println(pointList[n].score)
}

