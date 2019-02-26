fun main(args: Array<String>) {
    val (n, a, b, c) = readLine()!!.split(" ").map(String::toLong)
    val l = (1..n).map { readLine()!!.toLong() }
    var use = mutableListOf<MutableList<USE>>()

    // useにそれぞれの竹の利用方法の全パターンを網羅
    val USES = USE.values()
    USES.forEach { use.add(mutableListOf(it)) }
    for (i in 1 until n) {
        val temp = mutableListOf<MutableList<USE>>()
        use.forEach { oit -> USES.forEach { temp.add((oit + it).toMutableList()) } }
        use = temp
    }

    // 全てのパターンにおいてコストを計算して最小値を得る
    var minCost = Long.MAX_VALUE
    for (u in use) {
        if (!(u.contains(USE.A) && u.contains(USE.B) && u.contains(USE.C))) continue
        var tempA = 0L
        var tempB = 0L
        var tempC = 0L
        var cost = 0L
        u.forEachIndexed { index, tu ->
            if (tu == USE.A) {
                if (tempA != 0L) cost += 10;tempA += l[index]
            }
            if (tu == USE.B) {
                if (tempB != 0L) cost += 10;tempB += l[index]
            }
            if (tu == USE.C) {
                if (tempC != 0L) cost += 10;tempC += l[index]
            }
        }
        cost += Math.abs(a - tempA)
        cost += Math.abs(b - tempB)
        cost += Math.abs(c - tempC)
        minCost = Math.min(minCost, cost)
    }
    println(minCost)

}

enum class USE { A, B, C, N }

