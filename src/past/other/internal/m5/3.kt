package past.other.internal.m5

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xydList = mutableListOf<Triple<Int, Int, Int>>()
    val xyMap = Array(3001) { Array(3001) { -1 } }
    val distMap = mutableMapOf<Pair<Int,Int>,Int>()
    val ansArr = Array(n + 1) { 0 }
    (1..n).forEach {
        val (x, y, d) = readLine()!!.split(' ').map(String::toInt)
        xydList.add(Triple(x, y, d))
        //自分が聞こえる範囲全てに足す

        xyMap[x][y] = d
    }
    xydList.sortBy { it.second }
    xydList.sortBy { it.first }

}