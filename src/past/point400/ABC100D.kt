package past.point400


fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val xList = mutableListOf<Long>()
    val yList = mutableListOf<Long>()
    val zList = mutableListOf<Long>()

    for (i in 0 until n) {
        val (x, y, z) = readLine()!!.split(" ").map(String::toLong)
        xList.add(x)
        yList.add(y)
        zList.add(z)
    }
    val list1 = mutableListOf<Long>()
    val list2 = mutableListOf<Long>()
    val list3 = mutableListOf<Long>()
    val list4 = mutableListOf<Long>()
    val list5 = mutableListOf<Long>()
    val list6 = mutableListOf<Long>()
    val list7 = mutableListOf<Long>()
    val list8 = mutableListOf<Long>()

    for (i in 0 until n) {
        list1.add(xList[i] + yList[i] + zList[i])
        list2.add(xList[i] + yList[i] + zList[i] * -1)
        list3.add(xList[i] + yList[i] * -1 + zList[i])
        list4.add(xList[i] * -1 + yList[i] + zList[i])
        list5.add(xList[i] + yList[i] * -1 + zList[i] * -1)
        list6.add(xList[i] * -1 + yList[i] + zList[i] * -1)
        list7.add(xList[i] * -1 + yList[i] * -1 + zList[i])
        list8.add(xList[i] * -1 + yList[i] * -1 + zList[i] * -1)

    }
    var max = 0L
    max = Math.max(max, list1.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list2.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list3.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list4.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list5.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list6.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list7.sortedDescending().slice(0..(m - 1)).sum())
    max = Math.max(max, list8.sortedDescending().slice(0..(m - 1)).sum())

    println(max)
}
