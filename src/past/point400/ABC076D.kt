package past.point400

//なし(総当たり)
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val tList = readLine()!!.split(' ').map(String::toInt)
    val vList = readLine()!!.split(' ').map(String::toInt)
    val startList = mutableListOf(0)
    (0..(n - 2)).forEach { startList.add(startList.last() + tList[it]) }
    val maxSpeed = mutableMapOf<Double, Double>()
    val totalTime = tList.sum().toDouble()
    var i = 0.0
    while (i <= totalTime) {
        maxSpeed[i] = i
        i += 0.5
    }
    i = totalTime
    while (i >= 0) {
        maxSpeed[i] = Math.min(totalTime - i, maxSpeed[i]!!)
        i -= 0.5
    }
    for (j in 0 until n) {
        val t = tList[j]
        val v = vList[j]
        val start = startList[j]
        i = 0.0
        while (i <= totalTime) {
            val curSpeed = if (i <= start) {
                v.toDouble() + (start - i)
            } else if (i >= start + t) {
                v.toDouble() + (i - (start + t))
            } else {
                v.toDouble()
            }
            maxSpeed[i] = Math.min(maxSpeed[i]!!, curSpeed)
            i += 0.5
        }
    }
    var ans = 0.0
    i = 0.0
    while (i < totalTime) {
        ans += (maxSpeed[i]!! + maxSpeed[i + 0.5]!!) * 0.5 * 0.5
        i += 0.5
    }
    println(ans)
}
