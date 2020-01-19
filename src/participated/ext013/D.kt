package participated.ext013

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    aList.add(0, 0)
    val placeCardList = (0..n).toList().toIntArray()

    for (curPlace in 1 until n) {
        val curNumber = placeCardList[curPlace]
        val ngNum = aList[curNumber]
        val rightNumber = placeCardList.getOrNull(curPlace + 1) ?: break
        if (rightNumber == ngNum && placeCardList.getOrNull(curPlace + 2) != null) {
            val temp1 = placeCardList[curPlace + 1]
            placeCardList[curPlace + 1] = placeCardList[curPlace + 2]
            placeCardList[curPlace + 2] = temp1
        } else if (rightNumber == ngNum) {
            val temp1 = placeCardList[curPlace]
            placeCardList[curPlace] = placeCardList[curPlace + 1]
            placeCardList[curPlace + 1] = temp1
        }
    }
    for (curPlace in n downTo 1) {
        val curNumber = placeCardList[curPlace]
        val leftNumber = placeCardList[curPlace - 1]
        val ngNum = aList[leftNumber]
        if (curNumber == ngNum && leftNumber != 0) {
            val temp1 = placeCardList[curPlace]
            placeCardList[curPlace] = placeCardList[curPlace - 1]
            placeCardList[curPlace - 1] = temp1
        }
    }
    val curNumber = placeCardList[1]
    val rightNumber = placeCardList[2]
    val ngNum = aList[curNumber]
    if (rightNumber == ngNum) {
        println(-1)
        return
    }
    println(placeCardList.takeLast(n).joinToString(" "))
}