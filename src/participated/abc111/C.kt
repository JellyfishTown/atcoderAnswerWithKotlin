package participated.abc111

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val evenList = aList.filterIndexed { index, l -> index % 2 == 0 }
    val oddList = aList.filterIndexed { index, l -> index % 2 == 1 }
    val evenGroupBy = evenList.groupBy { it }.toSortedMap().toList().sortedByDescending { it.second.size }
    val oddGroupBy = oddList.groupBy { it }.toSortedMap().toList().sortedByDescending { it.second.size }

    var count1 = 0L
    count1 += evenList.size - evenGroupBy[0].second.size
    var flag1 = false
    for (i in oddGroupBy) {
        if (i.first != evenGroupBy[0].first) {
            count1 += oddList.size - i.second.size
            flag1 = true
            break
        }
    }
    if (!flag1) count1 += oddList.size

    var count2 = 0L
    count2 += oddList.size - oddGroupBy[0].second.size
    var flag2 = false
    for (i in evenGroupBy) {
        if (i.first != oddGroupBy[0].first) {
            count2 += evenList.size - i.second.size
            flag2 = true
            break
        }
    }
    if (!flag2) count2 += evenList.size

    println(Math.min(count1, count2))
}
