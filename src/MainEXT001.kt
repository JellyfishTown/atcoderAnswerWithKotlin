import java.util.*

//https://beta.atcoder.jp/contests/soundhound2018-summer-qual

val maxSize = 100001
var costMap = Array(maxSize, { Array(maxSize, { Long.MAX_VALUE }) })

fun calcCost(from: Int, to: Int) {
    var costList = costMap[from]

}

val yenMatrix = Array(maxSize, { Array(maxSize, { Long.MAX_VALUE }) })
val snuukMatrix = Array(maxSize, { Array(maxSize, { Long.MAX_VALUE }) })

fun main(args: Array<String>) {
    val (n, m, s, t) = readLine()!!.split(' ').map(String::toInt)
    val uList = mutableListOf<Int>()
    val vList = mutableListOf<Int>()
    val aList = mutableListOf<Int>()
    val bList = mutableListOf<Int>()

    for (i in 1..m) {
        val (u, v, a, b) = readLine()!!.split(' ').map(String::toInt)
        uList.add(u)
        vList.add(v)
        aList.add(a)
        bList.add(b)
    }
}

//fun past.point200.past.point400.abc106.abc104.main(args: Array<String>) {
//    val (n, m, s, t) = readLine()!!.split(' ').map(String::toInt)
//    val uList = mutableListOf<Int>()
//    val vList = mutableListOf<Int>()
//    val aList = mutableListOf<Int>()
//    val bList = mutableListOf<Int>()
//
//    val yenMatrix = DijkstraMatrix(n)
//    val snuukMatrix = DijkstraMatrix(n)
//    for (i in 1..m) {
//        val (u, v, a, b) = readLine()!!.split(' ').map(String::toInt)
//        uList.add(u)
//        vList.add(v)
//        aList.add(a)
//        bList.add(b)
//
//        yenMatrix.set(u, v, a)
//        snuukMatrix.set(u, v, b)
//    }
//
//
//    for (i in 0 until n) {
//        var minCost = Long.MAX_VALUE
//        for (j in 1..n) {
//            if (i >= j && i >= s && i >= t) continue
//            val yenCost1 = yenMatrix.getCost(s, j)
//            val yenCost2 = yenMatrix.getCost(j, t)
//            val snuukCost1 = snuukMatrix.getCost(s, j)
//            val snuukCost2 = snuukMatrix.getCost(j, t)
//            if (yenCost1 == null || yenCost2 == null || snuukCost1 == null || snuukCost2 == null) continue
//
//            if (i < j) minCost = Math.min(minCost, (yenCost1 + snuukCost2))
//            if (i < s) minCost = Math.min(minCost, (snuukCost1 + snuukCost2))
//            if (i < t) minCost = Math.min(minCost, (yenCost1 + yenCost2))
//
//        }
//        println(1000000000000000 - minCost)
//    }
//
//}


//C
//fun past.point200.past.point400.abc106.abc104.main(args: Array<String>) {
//    val (n, m, d) = readLine()!!.split(' ').map(String::toLong)
//    val sumBeauty = if (d != 0L) {
//        (n - d) * 2 * (m - 1)
//    } else {
//        n * (m - 1)
//    }
//    val aveBeauty = sumBeauty.toDouble() / n / n
//    println(aveBeauty)
//}

//B
//fun past.point200.past.point400.abc106.abc104.main(args: Array<String>) {
//    val s = readLine()!!.toCharArray()
//    val w = readLine()!!.toInt()
//    for (i in 0..(s.size - 1) step w) {
//        print(s[i])
//    }
//}


//A
//fun past.point200.past.point400.abc106.abc104.main(args: Array<String>) {
//    val (a, b) = readLine()!!.split(" ").map(String::toInt)
//    when {
//        (a + b) == 15 -> {
//            println("+")
//        }
//        (a * b) == 15 -> {
//            println("*")
//        }
//        else -> {
//            println("x")
//        }
//    }
//}