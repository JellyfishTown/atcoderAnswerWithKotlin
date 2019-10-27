package participated.abc144

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val fList = readLine()!!.split(' ').map(String::toLong).sorted()
    if (fList.sum() <= k) {
        println(0)
        return
    }
    val fScoreList = (0 until n.toInt()).map { fList[it] to aList[it] * fList[it] }.sortedByDescending { it.second }.toTypedArray()

    fun checkCanReach(targetScore: Long): Boolean {
        var totalCost = 0L
        for (fScore in fScoreList) {
            val (f, score) = fScore
            val diff = (score - targetScore)
            if (diff > 0) {
                totalCost += diff / f + if (diff % f == 0L) 0 else 1
                if (totalCost > k) return false
            } else return true
        }
        return true
    }

    var left = -1L
    var right = fScoreList.maxBy { it.second }!!.second
    while (true) {
        val targetScore = (left + right) / 2
        val canReach = checkCanReach(targetScore)
        if (left + 1 == right) {
            if (canReach) {
                if (checkCanReach(targetScore - 1)) {
                    println(targetScore - 1)
                } else {
                    println(targetScore)
                }
            } else {
                println(targetScore + 1)
            }
            return
        } else {
            if (canReach) {
                right = targetScore
            } else {
                left = targetScore
            }
        }
    }
}