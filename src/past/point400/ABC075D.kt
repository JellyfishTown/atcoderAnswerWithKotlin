package past.point400

//なし(総当たり)
fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val xyList = mutableListOf<Pair<Long, Long>>()
    (0 until n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toLong)
        xyList.add(Pair(x, y))
    }
    var ans = Long.MAX_VALUE / 2
    for (i1 in 0 until n) {
        val p1 = xyList[i1]
        for (i2 in 0 until n) {
            val p2 = xyList[i2]
            for (i3 in 0 until n) {
                val p3 = xyList[i3]
                for (i4 in 0 until n) {
                    val p4 = xyList[i4]
                    val minX = Math.min(p1.first, Math.min(p2.first, Math.min(p3.first, p4.first)))
                    val minY = Math.min(p1.second, Math.min(p2.second, Math.min(p3.second, p4.second)))
                    val maxX = Math.max(p1.first, Math.max(p2.first, Math.max(p3.first, p4.first)))
                    val maxY = Math.max(p1.second, Math.max(p2.second, Math.max(p3.second, p4.second)))
                    var countInnerP = 0
                    for (j in 0 until n) {
                        val (x, y) = xyList[j]
                        if (x in minX..maxX && y in minY..maxY) countInnerP++
                    }
                    if (countInnerP >= k) ans = Math.min(ans, (maxX - minX) * (maxY - minY))
                }
            }
        }
    }
    println(ans)
}
