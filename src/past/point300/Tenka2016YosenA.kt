fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val parent = IntArray(n)
    val drop = IntArray(n) { Integer.MAX_VALUE }
    drop[0] = 0
    for (i in 1 until n) {
        parent[i] = readLine()!!.toInt()
    }
    for (i in 0 until m) {
        val (b, c) = readLine()!!.split(" ").map(String::toInt)
        drop[b] = c
    }

    for (q in 1 until n) {
        var i = q
        while (parent[i] > 0) {
            drop[parent[i]] = Math.min(drop[parent[i]], drop[i])
            i = parent[i]
        }
    }

    println((1 until n).sumBy { drop[it] - drop[parent[it]] })
}
