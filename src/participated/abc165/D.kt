package participated.abc165

fun main(args: Array<String>) {
    val x = readLine()!!.toLong()
    val fiveList = (-200..200.toLong()).map { Pair(it, it * it * it * it * it) }
    for (i in 0 until fiveList.size) {
        for (j in 0 until fiveList.size) {
            if (fiveList[i].second - fiveList[j].second == x) {
                println("${fiveList[i].first} ${fiveList[j].first}")
                return
            }
        }
    }
}
