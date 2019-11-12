package participated.abc137

import java.util.*

fun main(args: Array<String>) {

    val (n, m, p) = readLine()!!.split(' ').map(String::toInt)
    val pointList = mutableListOf<Triple<Int,Int,Int>>()
    (1..m).forEach {
        val (a, b, c) = readLine()!!.split(' ').map(String::toInt)

    }
//
//    val queue = ArrayDeque<Int>()
//    queue.add(1)
//    while (queue.isNotEmpty()) {
//        val point = pointList[queue.pollFirst()]
//        point.visited = true
//
//        for ((to, coin) in point.to) {
//            val toPoint = pointList[to]
//            if (toPoint.visited && point.score + coin > toPoint.score) {
//                println(-1)
//                return
//            }else if (toPoint.visited){
//                //do nothing
//            }else{
//                toPoint.score = Math.max(toPoint.score, point.score + coin)
//                queue.add(to)
//            }
//        }
//    }
//    println(pointList[n].score)
}

