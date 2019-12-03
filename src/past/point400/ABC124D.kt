package past.point400

fun main(args: Array<String>) {
    val (x, y, z, k) = readLine()!!.split(" ").map(String::toLong)
    val xList = readLine()!!.split(" ").map(String::toLong).sortedDescending()
    val yList = readLine()!!.split(" ").map(String::toLong).sortedDescending()
    val zList = readLine()!!.split(" ").map(String::toLong).sortedDescending()

    val nums = mutableListOf<Long>()
    for (xi in xList.indices) {
        for (yi in yList.indices) {
            if (xi * yi > k) break
            for (zi in zList.indices) {
                if (xi * yi * zi > k) break
                val sum = xList[xi] + yList[yi] + zList[zi]
                nums.add(sum)
            }
        }
    }
    nums.sortDescending()
    for (i in 0 until k.toInt()) {
        println(nums[i])
    }
}
//fun past.point100.main(args: Array<String>) {
//    val (x, y, z, k) = readLine()!!.split(" ").map(String::toLong)
//    var xList = readLine()!!.split(" ").map(String::toLong).sorted()
//    var yList = readLine()!!.split(" ").map(String::toLong).sorted()
//    var zList = readLine()!!.split(" ").map(String::toLong).sorted()
//    val allList = mutableListOf<Pair<Long, Char>>()
//    xList.forEach { allList.add(Pair(it, 'x')) }
//    yList.forEach { allList.add(Pair(it, 'y')) }
//    zList.forEach { allList.add(Pair(it, 'z')) }
//    allList.sortBy { it.first }
//
//    var tx = x
//    var ty = y
//    var tz = z
//
//    var i = 0
//    while (true) {
//        when (allList[i].second) {
//            'x' -> tx--
//            'y' -> ty--
//            'z' -> tz--
//        }
//        if (tx * ty * tz < k) {
//            when (allList[i].second) {
//                'x' -> tx++
//                'y' -> ty++
//                'z' -> tz++
//            }
//            break
//        }
//        i++
//    }
//    xList = xList.takeLast(tx.toInt())
//    yList = yList.takeLast(ty.toInt())
//    zList = zList.takeLast(tz.toInt())
//
//    val nums = mutableListOf<Long>()
//    xList.forEach { x1 -> yList.forEach { y1 -> zList.forEach { z1 -> nums.add(x1 + y1 + z1) } } }
//    nums.sortDescending()
//
//    for (i in 0 until k.toInt()) {
//        println(nums[i])
//    }
//}
