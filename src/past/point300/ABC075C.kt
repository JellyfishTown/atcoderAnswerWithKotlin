package past.point300

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val ab = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(" ").map(String::toInt)
        ab.add(Pair(a - 1, b - 1))
    }

    var bridgeNum = 0
    for (i in 0 until m) {
        val graph = UnionFind(n)
        for (j in 0 until m) {
            if (i == j) continue
            graph.union(ab[j].first, ab[j].second)
        }

        val root = graph.root(0)
        for (i in 1 until n) {
            if (graph.root(i) != root) {
                bridgeNum++
                break
            }
        }
    }
    println(bridgeNum)
}

class UnionFind(private var num: Int) {
    private val parent: IntArray = IntArray(num)
    private val rank: IntArray = IntArray(num)

    init {
        for (i in 0 until num) {
            parent[i] = i
            rank[i] = 1
        }
    }

    fun union(u: Int, v: Int): Int {
        var u = u
        var v = v
        u = root(u)
        v = root(v)
        if (u == v)
            return u
        if (rank[v] < rank[u]) {
            val t = v
            v = u
            u = t
        }
        parent[u] = v
        rank[v] += rank[u]
        rank[u] = -1
        num--

        return v
    }

    fun root(u: Int): Int {
        var u = u
        while (parent[u] != u)
            u = parent[u]
        return u
    }
}