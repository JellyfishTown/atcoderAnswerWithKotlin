package participated.ext002


//https://aising2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val sList = mutableListOf<MutableList<Char>>()
    sList.add(Array(w + 2) { 'X' }.toMutableList())
    (1..h).forEach {
        val element = readLine()!!.toCharArray().toMutableList()
        element.add(0, 'X')
        element.add(element.size, 'X')
        sList.add(element)
    }
    sList.add(Array(w + 2) { 'X' }.toMutableList())
    val union = UnionFind(h * w)


    for (r in 1..h) {
        for (c in 1..w) {
            if (sList[r][c] == '#' && sList[r][c + 1] == '.') {
                union.union(calcGnum(r, c, w), calcGnum(r, c + 1, w))
            } else if (sList[r][c] == '#' && sList[r + 1][c] == '.') {
                union.union(calcGnum(r, c, w), calcGnum(r + 1, c, w))
            } else if (sList[r][c] == '.' && sList[r][c + 1] == '#') {
                union.union(calcGnum(r, c, w), calcGnum(r, c + 1, w))
            } else if (sList[r][c] == '.' && sList[r + 1][c] == '#') {
                union.union(calcGnum(r, c, w), calcGnum(r + 1, c, w))
            }
        }
    }

    val bNum = LongArray(h * w) { 0 }
    val wNum = LongArray(h * w) { 0 }
    for (r in 1..h) {
        for (c in 1..w) {
            if (sList[r][c] == '#') {
                bNum[union.root(calcGnum(r, c, w))]++
            } else {
                wNum[union.root(calcGnum(r, c, w))]++
            }
        }
    }
    println(bNum.mapIndexed { i, it -> it * wNum[i] }.sum())
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

fun calcGnum(r: Int, c: Int, w: Int) = (w * (r - 1) + c) - 1
