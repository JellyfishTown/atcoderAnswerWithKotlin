package past.point400

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    val hList = (1..n).map { readLine()!!.toLong() }

    fun checkCanKill(totalAttackNum: Long): Boolean {
        val damaged = hList.map { it - b * totalAttackNum }
        val left = damaged.filter { it > 0 }
        val killCount = left.map { it / (a - b) + if (it % (a - b) == 0L) 0 else 1 }
        val needAttackCount = killCount.sum()
        return needAttackCount <= totalAttackNum
    }

    var goalCount = 1L shl 30
    for (i in 29 downTo 0) {
        val diff = 1L shl i
        val currentIndex = goalCount - diff
        if (checkCanKill(currentIndex)) {
            goalCount -= diff
        }
    }
    println(goalCount)
}
