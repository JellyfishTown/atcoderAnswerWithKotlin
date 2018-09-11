package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toInt)

    val rank = mutableMapOf(
            Pair(1, 1..399),
            Pair(2, 400..799),
            Pair(3, 800..1199),
            Pair(4, 1200..1599),
            Pair(5, 1600..1999),
            Pair(6, 2000..2399),
            Pair(7, 2400..2799),
            Pair(8, 2800..3199)
    )
    val rankCount = mutableMapOf(
            Pair(1, 0),
            Pair(2, 0),
            Pair(3, 0),
            Pair(4, 0),
            Pair(5, 0),
            Pair(6, 0),
            Pair(7, 0),
            Pair(8, 0)
    )

    var overRank = 0
    for (a in aList) {
        if (a >= 3200) {
            overRank++
            continue
        }
        val rankKey = rank.filter {
            a in it.value
        }.keys.first()
        rankCount[rankKey] = rankCount[rankKey]!! + 1
    }
    val rankNum = rankCount.filter { it.value != 0 }.size
    val max = rankNum + overRank
    val min = Math.max(rankNum,1)

    println("$min $max")
}


