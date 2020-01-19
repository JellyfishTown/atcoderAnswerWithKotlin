package participated.abc148

import java.util.*

fun main(args: Array<String>) {
    val (n, taka, ao) = readLine()!!.split(' ').map(String::toInt)

    val branch = Array(n+1) { mutableSetOf<Int>() }
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        branch[a].add(b)
        branch[b].add(a)
    }
    val takaMinCost = LongArray(n + 1) { Long.MAX_VALUE / 2 }
    val aoMinCost = LongArray(n + 1) { Long.MAX_VALUE / 2 }

    takaMinCost[taka]=0
    aoMinCost[ao]=0
    val queue = ArrayDeque<Int>().apply { addFirst(taka) }
    while (queue.isNotEmpty()) {
        val cur = queue.pollLast()!!
        for (to in branch[cur]) {
            if (takaMinCost[to] > takaMinCost[cur] + 1) {
                takaMinCost[to] = takaMinCost[cur] + 1
                queue.addFirst(to)
            }
        }
    }
    queue.add(ao)
    while (queue.isNotEmpty()) {
        val cur = queue.pollLast()!!
        for (to in branch[cur]) {
            if (aoMinCost[to] > aoMinCost[cur] + 1) {
                aoMinCost[to] = aoMinCost[cur] + 1
                queue.addFirst(to)
            }
        }
    }

    val aoTakaDist = aoMinCost[taka]
    val cost = aoMinCost[(1..n).filter { aoMinCost[it] > takaMinCost[it] }.maxBy { aoMinCost[it] }!!]
    println(cost - 1)
}