package participated.abc138

import java.util.*

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map(String::toInt)
    val ansArray = Array(n + 1) { 0L }
    val tree = Array(n + 1) { mutableListOf<Int>() }
    val cost = Array(n + 1) { 0L }

    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        tree[a].add(b)
    }
    (1..q).forEach {
        val (p, x) = readLine()!!.split(' ').map(String::toInt)
        cost[p] = cost[p] + x
    }

    val queue = ArrayDeque<Int>()
    queue.add(1)
    while (queue.isNotEmpty()) {
        val index = queue.pollLast()!!
        ansArray[index] = cost[index]
        val to = tree[index]
        to.let {
            for (t in to) {
                queue.add(t)
                cost[t] = cost[index] + cost[t]
            }
        }
    }

    (1..n).forEach {
        print("${ansArray[it]} ")
    }
}
