import java.util.HashMap

//fun main(args: Array<String>) {
//    val (n, m) = readLine()!!.split(" ").map(String::toInt)
//    val fcn = mutableMapOf<Long, MutableMap<Long, Long>>()
//    for (i in 1..m) {
//        val (a, b, l) = readLine()!!.split(" ").map(String::toLong)
//        if (fcn.containsKey(a)) {
//            if (fcn[a]!!.containsKey(l)) {
//                fcn[a]!![l] = fcn[a]!![l]!! + 1
//            } else {
//                fcn[a]!![l] = 1
//            }
//        } else {
//            if (fcn[a]!!.containsKey(l)) {
//                fcn[a]!![l] = fcn[a]!![l]!! + 1
//            } else {
//                fcn[a]!![l] = 1
//            }
//        }
//    }
//    for (i in 1..n) {
//
//    }
//
//}


fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map(String::toInt)
    val aList = IntArray(M)
    val bList = IntArray(M)
    val lList = IntArray(M)
    for (i in 0 until M) {
        val (a, b, l) = readLine()!!.split(" ").map(String::toInt)
        aList[i] = a - 1
        bList[i] = b - 1
        lList[i] = l - 1000
    }
    val mapList = Array<MutableMap<Int, Int>>(N) { mutableMapOf() }
    for (i in 0 until M) {
        (mapList[aList[i]]).merge(lList[i], 1) { v1, v2 -> v1 + v2 }
        (mapList[bList[i]]).merge(lList[i], 1) { v1, v2 -> v1 + v2 }
    }
    var cnt = 0
    for (i in 0 until N) {
        for (j in 0..540) {
            if (j == 270) {
                if (mapList[i].containsKey(j)) {
                    val t = mapList[i][j]!!
                    cnt += t * (t - 1)
                }
            } else {
                if (mapList[i].containsKey(j) && mapList[i].containsKey(540 - j)) {
                    cnt += mapList[i][j]!! * mapList[i][540 - j]!!
                }
            }
        }
    }
    println(cnt / 2)
}

//
//fun main(args: Array<String>) {
//    val (n, m) = readLine()!!.split(" ").map(String::toInt)
//    val abl = mutableListOf<Triple<Long, Long, Long>>()
//    val lab = mutableMapOf<Long, MutableList<Pair<Long, Long>>>()
//    for (i in 1..m) {
//        val (a, b, l) = readLine()!!.split(" ").map(String::toLong)
//        abl.add(Triple(a, b, l))
//        if (lab.containsKey(l)) lab[l]!!.add(Pair(a, b)) else lab[l] = mutableListOf(Pair(a, b))
//    }
//    abl.sortBy { it.third }
//
//    var ans = 0L
//    for ((a, b, l) in abl) {
//        if (l < 1000 || l > 1270 || lab.containsKey(l).not()) continue
//        val targets = lab[l]!!
//
//        for(target in targets){}
//
//    }
//
//}
