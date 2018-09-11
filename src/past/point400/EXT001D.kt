package past.point400

//https://beta.atcoder.jp/contests/soundhound2018-summer-qual

import java.util.*

fun main(args: Array<String>) {
    val (n, m, start, goal) = readLine()!!.split(' ').map(String::toInt)
    val yenNodes = mutableMapOf<Int, Node>()
    val snuukNodes = mutableMapOf<Int, Node>()

    for (i in 1..n) {
        yenNodes[i] = Node(i)
        snuukNodes[i] = Node(i)
    }
    for (i in 1..m) {
        val (from, to, yenCost, snuukCost) = readLine()!!.split(' ').map(String::toInt)
        yenNodes[from]!!.edgesTo.add(to)
        yenNodes[from]!!.edgesCost.add(yenCost.toLong())
        yenNodes[to]!!.edgesTo.add(from)
        yenNodes[to]!!.edgesCost.add(yenCost.toLong())

        snuukNodes[from]!!.edgesTo.add(to)
        snuukNodes[from]!!.edgesCost.add(snuukCost.toLong())
        snuukNodes[to]!!.edgesTo.add(from)
        snuukNodes[to]!!.edgesCost.add(snuukCost.toLong())
    }

    calcDijkstraCost(yenNodes, start)
    calcDijkstraCost(snuukNodes, goal)

    for (i in 0 until n) {
        var minCost = Long.MAX_VALUE
        for (j in (i + 1)..n) {
            minCost = Math.min(minCost, yenNodes[j]!!.cost + snuukNodes[j]!!.cost)
        }
        println(1000000000000000 - minCost)
    }
}


class Node(val id: Int) {
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

    override fun equals(other: Any?): Boolean {
        val o: Node? = other as Node?
        return this.id == o?.id ?: false
    }
}

private fun calcDijkstraCost(nodes: Map<Int, Node>, start: Int) {
    val queue = PriorityQueue<Node>(11, Comparator<Node> { o1: Node, o2: Node -> (o1.cost - o2.cost).toInt() })

    nodes[start]!!.cost = 0
    queue.add(nodes[start])

    while (queue.isNotEmpty()) {
        val doneNode = queue.remove()
        doneNode.done = true

        for (i in 0 until doneNode.edgesTo.size) {
            val to = doneNode.edgesTo[i]
            val cost = doneNode.cost + doneNode.edgesCost[i]
            if (nodes[to]!!.done.not() && cost < nodes[to]!!.cost) {
                nodes[to]!!.cost = cost
                nodes[to]!!.from = doneNode
                if (queue.contains(nodes[to]).not()) queue.add(nodes[to])
            }
        }
    }
}
