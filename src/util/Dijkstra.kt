package util

import java.util.*

fun main() {
    val node = mutableMapOf<Int,Node>()
//    ノードへのデータ登録

    calcDijkstraCost(node,0)
}
class Node : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return if (this.id == other.id) 0 else 1
    }

    private val id = Math.random()
    val edgesTo = mutableListOf<Int>()

    val edgesCost = mutableListOf<Long>()
    var done = false
    var cost = Long.MAX_VALUE
    var from: Node? = null

    fun reset() {
        done = false
        cost = Long.MAX_VALUE
        from = null
    }
}

private fun calcDijkstraCost(nodes: Map<Int, Node>, start: Int) {
    val queue = PriorityQueue<Node>()
    nodes[start]!!.cost = 0
    queue.add(nodes[start])

    while (queue.isNotEmpty()) {
        val doneNode = queue.remove()
        doneNode.done = true

        for (i in 0 until doneNode.edgesTo.size) {
            val to = doneNode.edgesTo[i]
            val cost = doneNode.cost + doneNode.edgesCost[i]
            if (cost < nodes[to]!!.cost) {
                nodes[to]!!.cost = cost
                nodes[to]!!.from = doneNode
                if (queue.contains(nodes[to]).not()) queue.add(nodes[to])
            }
        }
    }
}