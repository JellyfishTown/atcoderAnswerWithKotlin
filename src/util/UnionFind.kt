package util

//https://gist.github.com/drmalex07/3e6695025a1788e669cec7f8d93d98dc
//を参考にUnionFindクラスを作成
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
