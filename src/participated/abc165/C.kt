package participated.abc165

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val hList = readLine()!!.split(' ').map(String::toLong)
    val goodArray = BooleanArray(n) { true }
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() - 1 }
        if (hList[a] <= hList[b]) goodArray[a] = false
        if (hList[a] >= hList[b]) goodArray[b] = false
    }
    println(goodArray.count { it })
}
