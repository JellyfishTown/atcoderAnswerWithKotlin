package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    aList.add(0, 0)
    aList.add(0)

    val betweenFlg = mutableListOf<Boolean>()
    for (i in 1 until n + 1) {
        betweenFlg.add(aList[i] in aList[i - 1]..aList[i + 1] || aList[i] in aList[i + 1]..aList[i - 1])
    }

    var totalCost = 0L
    for (i in 1 until n + 2) {
        totalCost += Math.abs(aList[i] - aList[i - 1])
    }

    for (i in 1 until n + 1) {
        if (betweenFlg[i - 1]) {
            println(totalCost)
        } else {
            val removalCost = Math.min(Math.abs(aList[i] - aList[i - 1]), Math.abs(aList[i + 1] - aList[i])) * 2
            println(totalCost - removalCost)
        }
    }

}

