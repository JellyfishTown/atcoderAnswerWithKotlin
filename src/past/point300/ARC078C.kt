package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val aAccum = mutableListOf(aList[0])
    for (i in 1 until n) {
        aAccum.add(aAccum[i - 1] + aList[i])
    }
    val aSum = aAccum[aAccum.size - 1]
    var min = Long.MAX_VALUE
    for (i in 0 until (n - 1)) {
        val tempMin = Math.abs(aAccum[i] - (aSum - aAccum[i]))
        min = Math.min(min, tempMin)
    }
    println(min)
}
