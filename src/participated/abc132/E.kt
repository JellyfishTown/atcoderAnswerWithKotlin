package participated.abc132

import java.util.*

fun main(args: Array<String>) {
    data class Node(
            val to: MutableList<Int> = mutableListOf(),
            var visited: MutableMap<Int, Boolean> = mutableMapOf(0 to false, 1 to false, 2 to false),
            var min: MutableMap<Int, Int> = mutableMapOf(0 to Int.MAX_VALUE, 1 to Int.MAX_VALUE, 2 to Int.MAX_VALUE)
    )

    data class Value(
            val index: Int,
            var num: Int,
            var ken: Int
    )
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val nodes = mutableMapOf<Int, Node>()
    for (i in 1..n) {
        nodes[i] = Node()
    }
    for (i in 1..m) {
        val (u, v) = readLine()!!.split(' ').map(String::toInt)
        nodes[u]!!.to.add(v)
    }
    val (s, t) = readLine()!!.split(' ').map(String::toInt)
    val queue = ArrayDeque<Value>()
    nodes[s]!!.to.forEach {
        queue.addLast(Value(it, 0, 1))
    }

    while (queue.isNotEmpty()) {
        val value = queue.pollFirst()
        val (index, num, ken) = Triple(value.index, value.num, value.ken)
        val node = nodes[index]!!

        if (node.visited[num]!!) {
            if (node.min[num]!! <= ken) {
                continue
            } else {
                node.min[num] = ken
                if (num == 2) {
                    node.to.forEach { queue.addLast(Value(it, 0, ken + 1)) }
                } else {
                    node.to.forEach { queue.addLast(Value(it, num + 1, ken)) }
                }
            }
        } else {
            node.visited[num] = true
            node.min[num] = ken
            if (num == 2) {
                node.to.forEach { queue.addLast(Value(it, 0, ken + 1)) }
            } else {
                node.to.forEach { queue.addLast(Value(it, num + 1, ken)) }
            }
        }

    }
    if (nodes[t]!!.visited[2]!!) {
        println(nodes[t]!!.min[2])

    } else {
        println(-1)
    }
}

