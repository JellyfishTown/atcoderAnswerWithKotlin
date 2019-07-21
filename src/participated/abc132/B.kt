package participated.abc132

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toLong)

    var count = 0
    (1 until (n - 1)).forEach {
        val list = mutableListOf<Long>(pList[it - 1], pList[it], pList[it + 1]).sorted()
        if (list[1]==pList[it])count++
    }

    println(count)
}
