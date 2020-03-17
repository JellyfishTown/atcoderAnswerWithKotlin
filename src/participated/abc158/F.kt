package participated.abc158

import java.util.*

fun main(args: Array<String>) {
    data class Node(
            val id: Int,
            var x:Long = 0,
            var d:Long = 0,
            val child: MutableList<Node> = mutableListOf(),
            var parent: Node? = null,
            var live: Long = 1,
            var dead: Long = 1
    )

    val n = readLine()!!.toInt()
    var xdList = (1..n).map {
        val (c, d) = readLine()!!.split(' ').map(String::toLong)
        Pair(c, d)
    }
    xdList =  xdList.sortedBy { it.first }
    fun binarySearch(key: Long): Int {
        fun isOk(index: Int, key: Long): Boolean {
            return xdList[index].first >= key
        }

        var ngIndex = -1
        var okIndex = xdList.size

        while (Math.abs(okIndex - ngIndex) > 1) {
            val mid = (okIndex + ngIndex) / 2
            if (isOk(mid, key)) okIndex = mid
            else ngIndex = mid
        }
        return okIndex
    }

    val nodeList = Array(n) { Node(id = it,x = xdList[it].first,d = xdList[it].second) }
    for (i in n downTo 1){

    }

    for (i in 0 until n) {
        val (x, d) = xdList[i]
        val key = x + d
        val rightIndex = binarySearch(key)
        println("1")
    }

    if (true) {
        println()
    } else {
        println()
    }


}
