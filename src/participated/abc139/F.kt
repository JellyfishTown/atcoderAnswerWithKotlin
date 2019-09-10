package participated.abc139

fun main(args: Array<String>) {
    fun calcDist(x: Double, y: Double) = Math.sqrt((x * x + y * y))
    val n = readLine()!!.toInt()
    val xyrList = mutableListOf<Triple<Double, Double, Double>>()
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toDouble)
        xyrList.add(Triple(x, y, Math.atan2(y, x)))
    }
    xyrList.sortBy { it.third }
    xyrList.addAll(xyrList)
    var ans = 0.0
    for (start in 0 until n) {
        var end = start
        var curDist = calcDist(xyrList[start].first, xyrList[start].second)
        while (++end - start < n) {
            val subList = xyrList.subList(start, end + 1)
            val nextDist = calcDist(subList.map { it.first }.sum(), subList.map { it.second }.sum())
            if (curDist > nextDist) break else curDist = nextDist
        }
        ans = Math.max(ans, curDist)
    }
    println(ans)
}

//
//    val xydList1 = xydList.filter { (it.first > 0 && it.second > 0).not() }
//    val xydList2 = xydList.filter { (it.first < 0 && it.second > 0).not() }
//    val xydList3 = xydList.filter { (it.first < 0 && it.second < 0).not() }
//    val xydList4 = xydList.filter { (it.first > 0 && it.second < 0).not() }
//
//    var ans = 0.0
//
//    var (curX, curY, curDist) = Triple(0L, 0L, 0.0)
//    for ((x, y, d) in xydList1) {
//        val nextDist = calcDist(curX + x, curY + y)
//        if (curDist < nextDist) {
//            curX += x
//            curY += y
//            curDist = nextDist
//        }
//    }
//    ans = Math.max(ans, curDist)
//
//    curX = 0L
//    curY = 0L
//    curDist = 0.0
//    for ((x, y, d) in xydList2) {
//        val nextDist = calcDist(curX + x, curY + y)
//        if (curDist < nextDist) {
//            curX += x
//            curY += y
//            curDist = nextDist
//        }
//    }
//    ans = Math.max(ans, curDist)
//    curX = 0L
//    curY = 0L
//    curDist = 0.0
//    for ((x, y, d) in xydList3) {
//        val nextDist = calcDist(curX + x, curY + y)
//        if (curDist < nextDist) {
//            curX += x
//            curY += y
//            curDist = nextDist
//        }
//    }
//    ans = Math.max(ans, curDist)
//    curX = 0L
//    curY = 0L
//    curDist = 0.0
//    for ((x, y, d) in xydList4) {
//        val nextDist = calcDist(curX + x, curY + y)
//        if (curDist < nextDist) {
//            curX += x
//            curY += y
//            curDist = nextDist
//        }
//    }
//    ans = Math.max(ans, curDist)
//    println(ans)
//}


//xydList.sortByDescending { it.third }
//
//var ans = 0.0
//
//for (i in 0 until n) {
//    var curDist = 0.0
//    var curX = 0L
//    var curY = 0L
//    for (j in i until n) {
//        val (x, y, d) = xydList[j]
//        val nextDist = calcDist(curX + x, curY + y)
//        if (curDist < nextDist) {
//            curX += x
//            curY += y
//            curDist = nextDist
//        }
//    }
//    ans = Math.max(ans, curDist)
//}
//println(ans)
