package past.point400

//なし(総当たり)
fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val xArray = LongArray(n) { 0 }
    val yArray = LongArray(n) { 0 }
    (0 until n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toLong)
        xArray[it] = x
        yArray[it] = y
    }
    var ans = Long.MAX_VALUE / 2
    for (i1 in 0 until n) {
        val x1 = xArray[i1]
        val y1 = yArray[i1]
        for (i2 in 0 until n) {
            val x2 = xArray[i2]
            val y2 = yArray[i2]
            for (i3 in 0 until n) {
                val x3 = xArray[i3]
                val y3 = yArray[i3]
                for (i4 in 0 until n) {
                    val x4 = xArray[i4]
                    val y4 = yArray[i4]
                    val minX = Math.min(x1, Math.min(x2, Math.min(x3, x4)))
                    val minY = Math.min(y1, Math.min(y2, Math.min(y3, y4)))
                    val maxX = Math.max(x1, Math.max(x2, Math.max(x3, x4)))
                    val maxY = Math.max(y1, Math.max(y2, Math.max(y3, y4)))
                    var countInnerP = 0
                    for (j in 0 until n) {
                        val x = xArray[j]
                        val y = yArray[j]
                        if (x in minX..maxX && y in minY..maxY) countInnerP++
                    }
                    if (countInnerP >= k) ans = Math.min(ans, (maxX - minX) * (maxY - minY))
                }
            }
        }
    }
    println(ans)
}
