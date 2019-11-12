package participated.abc144

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    val fList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    if (aList.sum() <= k) {
        println(0)
        return
    }

    fun checkCanReach(v: Long): Boolean {
        var sum = 0L
        for (i in 0 until n.toInt()) {
            val ma = v / fList[i]
            if (ma < aList[i]) sum += aList[i] - ma
            if (sum > k) return false
        }
        return true
    }
//二分探索
    var goalIndex = 1L shl 60
    for (i in 59 downTo 0) {
        val diff = 1L shl i
        val currentIndex = goalIndex - diff
        if (checkCanReach(currentIndex)) {
            goalIndex -= diff
        }
    }
    println(goalIndex)
}

//
//fun main(args: Array<String>) {
//    val (n, k) = readLine()!!.split(' ').map(String::toLong)
//    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
//    val fList = readLine()!!.split(' ').map(String::toLong).sorted()
//    if (fList.sum() <= k) {
//        println(0)
//        return
//    }
//    val fScoreList = (0 until n.toInt()).map { fList[it] to aList[it] * fList[it] }.sortedByDescending { it.second }.toTypedArray()
//
//    fun checkCanReach(targetScore: Long): Boolean {
//        var totalCost = 0L
//        for (fScore in fScoreList) {
//            val (f, score) = fScore
//            val diff = (score - targetScore)
//            if (diff > 0) {
//                totalCost += diff / f + if (diff % f == 0L) 0 else 1
//                if (totalCost > k) return false
//            } else return true
//        }
//        return true
//    }
//
//    var left = -1L
//    var right = fScoreList.maxBy { it.second }!!.second
//    while (true) {
//        val targetScore = (left + right) / 2
//        val canReach = checkCanReach(targetScore)
//        if (left + 1 == right) {
//            if (canReach) {
//                if (checkCanReach(targetScore - 1)) {
//                    println(targetScore - 1)
//                } else {
//                    println(targetScore)
//                }
//            } else {
//                println(targetScore + 1)
//            }
//            return
//        } else {
//            if (canReach) {
//                right = targetScore
//            } else {
//                left = targetScore
//            }
//        }
//    }
//}
