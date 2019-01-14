package participated.agc030

fun main(args: Array<String>) {
    val (l, n) = readLine()!!.split(' ').map(String::toLong)
    val xList = mutableListOf<Long>()
    (1..n).forEach { xList.add(readLine()!!.toLong()) }
    val xReversedList = xList.reversed().map { l - it }.toMutableList()
    val xSumList = mutableListOf<Long>()
    val xReversedSumList = mutableListOf<Long>()
    xSumList.add(xList.first())
    xReversedSumList.add(xReversedList.first())
    for (i in 1 until xList.size) {
        xSumList.add(xList[i] + xSumList[i - 1])
        xReversedSumList.add(xReversedList[i] + xReversedSumList[i - 1])
    }

    if (n == 1L) {
        println(Math.max(xList.first(), l - xList.first()))
    } else if (n == 2L) {
        println(Math.max(
                Math.max(xList.last(), xList.first()),
                Math.max((l - xList.last()) * 2 + xList.first(), (l - xList.first()) * 2 + xList.last())))
    }else{
        var sum = 0L
        var max = 0L

    }


//    println(sum)
}
