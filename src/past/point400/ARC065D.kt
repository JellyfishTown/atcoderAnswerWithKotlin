package past.point400

fun main(args: Array<String>) {
    class UnionFind(private var num: Int) {
        private val parent: IntArray = IntArray(num)
        private val rank: IntArray = IntArray(num)
        private val size: IntArray = IntArray(num)

        init {
            for (i in 0 until num) {
                parent[i] = i
                rank[i] = 1
                size[i] = 1
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

    val (n, k, l) = readLine()!!.split(' ').map(String::toInt)
    val pqList = (1..k).map {
        val (p, q) = readLine()!!.split(' ').map(String::toInt)
        Pair(p, q)
    }
    val rsList = (1..l).map {
        val (r, s) = readLine()!!.split(' ').map(String::toInt)
        Pair(r, s)
    }

    val pqUnion = UnionFind(n+1)
    val rsUnion = UnionFind(n+1)
    pqList.forEach {
        pqUnion.union(it.first, it.second)
    }
    rsList.forEach {
        rsUnion.union(it.first, it.second)
    }

    val routeList = IntArray(n + 1) { pqUnion.root(it) }
    val trainList = IntArray(n + 1) { rsUnion.root(it) }

    val ps = mutableMapOf<Pair<Int, Int>, Int>()
    for (i in 1..n) {
        val p = Pair(routeList[i], trainList[i])
        if (ps.containsKey(p)) {
            ps[p] = ps[p]!! + 1
        } else {
            ps[p] = 1
        }
    }
    for (i in 1..n) {
        val p = Pair(routeList[i], trainList[i])
        print(ps[p]!!.toString() + " ")
    }
    println()
}
