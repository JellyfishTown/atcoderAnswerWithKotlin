package participated.abc135

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toLong)
    val sortedP = pList.sorted()

    var count = 0
    (0 until n).forEach { if (pList[it] != sortedP[it]) count++ }

    if (count <= 2) {
        println("YES")

    } else {
        println("NO")
    }
}
