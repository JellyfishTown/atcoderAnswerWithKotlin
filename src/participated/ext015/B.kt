package participated.ext015

fun main(args: Array<String>) {
    val (a, b, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val bList = readLine()!!.split(' ').map(String::toLong)
    val xycList = (1..m).map {
        val (x, y, c) = readLine()!!.split(' ').map(String::toLong)
        Triple(x, y, c)
    }

    var minCost = aList.min()!! + bList.min()!!
    for (i in 0 until m) {
        val (x, y, c) = xycList[i.toInt()]
        minCost = Math.min(minCost, aList[x.toInt() - 1] + bList[y.toInt() - 1] - c)
    }
    println(minCost)
}
