package participated.abc157

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
            val t = size[u]
            size[u] = t + size[v]
            size[v] = t + size[v]
            return v
        }

        fun root(u: Int): Int {
            var u = u
            while (parent[u] != u)
                u = parent[u]
            return u
        }

        fun size(u: Int): Int {
            return size[root(u)]
        }
    }
    val (n, m, k) = readLine()!!.split(' ').map(String::toInt)
    val union = UnionFind(n)
    val friendNum = IntArray(n)
    val blockNum = IntArray(n)
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        union.union(a - 1, b - 1)
        friendNum[a - 1]++
        friendNum[b - 1]++
    }
    for (i in 1..k) {
        val (c, d) = readLine()!!.split(' ').map(String::toInt)
        if (union.root(c - 1) == union.root(d - 1)) {
            blockNum[c - 1]++
            blockNum[d - 1]++
        }
    }

    for (i in 0 until n) {
        val size = union.size(i)
        val fn = friendNum[i]
        val bn = blockNum[i]
        print("${size - fn - bn - 1} ")
    }
    println()
}
