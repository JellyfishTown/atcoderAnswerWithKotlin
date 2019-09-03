package participated.abc139

fun main(args: Array<String>) {
    fun calcDist(x: Long, y: Long) = Math.sqrt((x * x + y * y).toDouble())
    val n = readLine()!!.toInt()
    val xyList = mutableListOf<Pair<Long, Long>>()
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toLong)
        xyList.add(Pair(x, y))
    }
    var ans = 0.0

    for (i in 0 until n) {
        val (x, y) = xyList[i]
        val filtered =
                xyList.filterIndexed { index, pair -> index == i || (x * pair.first + y * pair.second) >= 0 }
        ans = Math.max(ans, calcDist(filtered.map { it.first }.sum(), filtered.map { it.second }.sum()))
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