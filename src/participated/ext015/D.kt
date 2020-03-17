package participated.ext015

import com.sun.org.apache.xpath.internal.operations.Bool

fun main(args: Array<String>) {
    fun binarySearch(list: Array<Int>, key: Int): Int {
        fun isOk(index: Int, key: Int): Boolean {
            return list[index] <= key
        }

        var ngIndex = -1
        var okIndex = list.size

        while (Math.abs(okIndex - ngIndex) > 1) {
            val mid = (okIndex + ngIndex) / 2
            if (isOk(mid, key)) okIndex = mid
            else ngIndex = mid
        }
        return okIndex
    }
    val (n, t) = readLine()!!.split(' ').map(String::toLong)
    val abtList = (1..n).map {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        Triple(a, b, (t - b) / a)
    }
    abtList.sortedByDescending { it.third }

//    fun checkCanReach(currentIndex: Long): Boolean {
//
//        var curT = t
//        for ((a, b, t) in stores) {
//            curT = curT - 3 -
//        }
//    }
//
//    //二分探索
//    var goalIndex = n
//    for (i in 1..50) {
//        val diff = n shr i
//        val currentIndex = goalIndex - diff
//        if (checkCanReach(currentIndex)) {
//            goalIndex -= diff
//        }
//        if (diff == 0L) break
//    }

}
