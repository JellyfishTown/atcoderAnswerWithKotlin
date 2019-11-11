package participated.ext012

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val bList = readLine()!!.split(' ').map(String::toLong)

    val aS = aList.sorted()
    val bS = bList.sorted()

    val abS = (0 until n).map { Pair(aList[it],bList[it]) }.sortedBy { it.second }

    val isOk = (0 until n).all { aS[it] <= bS[it] }
    val moveCount = (0 until n).count { aList[it] > bList[it] }
    val okCount = (0 until n).count { aS[it] == abS[it].first }
    val isNg = okCount == 0

    if (isOk && isNg.not()) {
        println("Yes")
    } else {
        println("No")
    }
}