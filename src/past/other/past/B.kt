package past.other.past

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<Long>()
    (1..n).forEach { aList.add(readLine()!!.toLong()) }

    for (d in 0..(n - 2)) {
        val today = aList[d]
        val tomorrow = aList[d + 1]
        println(
                when {
                    today == tomorrow -> "stay"
                    today > tomorrow -> "down ${today - tomorrow}"
                    else -> "up ${tomorrow - today}"
                }
        )
    }
}
