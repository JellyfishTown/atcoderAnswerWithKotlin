package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val cArray = s.toCharArray()
    val eMax = cArray.sumBy { if (it == 'E') 1 else 0 }
    var eCount = 0
    var wCount = 0
    val turnNumList = mutableListOf<Int>()
    for (c in cArray) {
        if (c == 'E') eCount++
        turnNumList.add(wCount + eMax - eCount)
        if (c == 'W') wCount++
    }
    println(turnNumList.min())
}

