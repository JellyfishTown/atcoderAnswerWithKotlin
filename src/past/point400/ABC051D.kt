package past.point400
//未完成
import java.util.*

val nodes = mutableMapOf<Int, Node>()
val edges = mutableListOf<Pair<Int, Int>>()
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    (1..n).forEach { nodes[it] = Node(it) }
    for (i in 1..m) {
        val (a, b, c) = readLine()!!.split(" ").map(String::toInt)
        nodes[a]!!.edgesTo.add(b)
        nodes[a]!!.edgesCost.add(c.toLong())
        nodes[b]!!.edgesTo.add(a)
        nodes[b]!!.edgesCost.add(c.toLong())
        edges.add(Pair(Math.min(a, b), Math.max(a, b)))
    }
    for (i in 1..(n - 1)) {
        nodes.values.forEach { it.reset() }
        calcDijkstraCost(i)
        for (j in (i + 1)..n) {
            removeUsedEdges(j)
        }
    }
    println(edges.size)
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

private fun calcDijkstraCost(start: Int) {
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

private fun removeUsedEdges(goal: Int) {
    var currentNode = nodes[goal]!!
    while (currentNode.from != null) {
        edges.remove(Pair(Math.min(currentNode.id, currentNode.from!!.id),
                Math.max(currentNode.id, currentNode.from!!.id)))
        currentNode = currentNode.from!!
    }
}
