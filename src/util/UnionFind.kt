package util

//https://gist.github.com/drmalex07/3e6695025a1788e669cec7f8d93d98dc
//を参考にUnionFindクラスを作成
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


//別パターン
fun find(tree: IntArray, idx: Int): Int {
    return if (tree[idx] == idx)
        idx
    else{
        val find = find(tree, tree[idx])
        tree[idx] = find
        find
    }
}
//union idx2 tree to idx1 tree O(a(N))
fun union(tree: IntArray, idx1: Int, idx2: Int) {
    val root1 = find(tree, idx1)
    val root2 = find(tree, idx2)
    tree[root2] = root1
}
