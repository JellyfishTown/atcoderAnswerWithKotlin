package past.point400

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val abList = Array(m.toInt()) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        Pair(a - 1, b - 1)
    }.toMutableList().apply { this.removeAt(0) }.reversed()

    val cost = mutableListOf<Long>().apply { this.add(n * (n - 1) / 2) }
    val union = UnionFind(n.toInt())

    for ((a, b) in abList) {
        if (union.root(a) == union.root(b)) {
            cost.add(cost.last())
        } else {
            cost.add(cost.last() - union.size(a) * union.size(b))
        }
        union.union(a, b)
    }
    cost.reversed().forEach(::println)
}

class UnionFind(num: Int) {
    val parent = IntArray(num) { it }
    val rank = IntArray(num) { 1 }

    fun union(u: Int, v: Int): Int {
        var ru = root(u)
        var rv = root(v)
        if (ru == rv)
            return ru
        if (rank[rv] < rank[ru]) {
            val temp = rv
            rv = ru
            ru = temp
        }
        parent[ru] = rv
        rank[rv] += rank[ru]
        rank[ru] = -1
        return rv
    }

    fun root(u: Int): Int {
        var tu = u
        while (parent[tu] != tu)
            tu = parent[tu]
        return tu
    }

    fun size(u: Int): Int {
        return rank[this.root(u)]
    }
}
