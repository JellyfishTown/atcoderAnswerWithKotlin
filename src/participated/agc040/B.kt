package participated.agc040

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var lrList = (1..n).map {
        val (l, r) = readLine()!!.split(" ").map(String::toLong)
        Pair(l, r)
    }
    lrList = lrList.sortedBy{ it.second }
    lrList = lrList.sortedBy { it.first }

    val leftSecondMinMap = Array(n) { lrList.first().second }
    val rightSecondMinMap = Array(n) { lrList.last().second }
    (1 until n).forEach { leftSecondMinMap[it] = Math.min(lrList[it].second, leftSecondMinMap[it - 1]) }
    (n - 2 downTo 0).forEach { rightSecondMinMap[it] = Math.min(lrList[it].second, rightSecondMinMap[it + 1]) }

    var maxScore = 0L
    for (i in 0 until n - 1) {
        val s1 = Math.max(0, leftSecondMinMap[i] - lrList[i].first + 1)
        val s2 = Math.max(0, rightSecondMinMap[i + 1] - lrList.last().first + 1)
        maxScore = Math.max(maxScore, s1 + s2)
    }

    lrList = lrList.sortedByDescending { it.second - it.first }
    val s3 = lrList[0].second - lrList[0].first+1
    val s4 = Math.max((1 until n).map{lrList[it].second}.min()!! - (1 until n).map{lrList[it].first}.max()!! + 1,0)
    maxScore = Math.max(maxScore,s3+s4)

    println(maxScore)
}