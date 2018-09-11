package past.point400

import kotlin.system.measureTimeMillis

val dGrid = mutableListOf<List<Int>>()
var C = 0

val list0M = mutableMapOf<Int,Int>()
val list1M = mutableMapOf<Int,Int>()
val list2M = mutableMapOf<Int,Int>()
fun main(args: Array<String>) {
    val (n, c) = readLine()!!.split(" ").map(String::toInt)
    C = c
    val list0 = mutableListOf<Int>()
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    for (i in 1..c) {
        dGrid.add(readLine()!!.split(' ').map(String::toInt))
    }

    for (i in 1..n) {
        val cList = readLine()!!.split(' ').map(String::toInt)
        list0.addAll(cList.filterIndexed { index, it -> (index + i + 1) % 3 == 0 })
        list1.addAll(cList.filterIndexed { index, it -> (index + i + 1) % 3 == 1 })
        list2.addAll(cList.filterIndexed { index, it -> (index + i + 1) % 3 == 2 })
    }

    for (i in 1..c) {
        list0M[i] = list0.filter { it == i }?.size?:0
        list1M[i] = list1.filter { it == i }?.size?:0
        list2M[i] = list2.filter { it == i }?.size?:0
    }
    val millis = measureTimeMillis { run() }

}

private fun run() {



    var min = Long.MAX_VALUE
    for (c1 in 1..C) {
        for (c2 in 1..C) {
            if (c1 == c2) continue
            for (c3 in 1..C) {
                if ((c1 == c2) || (c2 == c3) || (c1 == c3)) continue

                val sum = calcD(c1, list0M) + calcD(c2, list1M) + calcD(c3, list2M)
                min = Math.min(sum, min)
            }
        }
    }
    println(min)
}

fun calcD(c: Int, map: Map<Int, Int>): Long {
    var sum = 0L
    for (i in 1..C) {
        sum += dGrid[i - 1][c - 1] * map!![i]!!
    }
    return sum
}