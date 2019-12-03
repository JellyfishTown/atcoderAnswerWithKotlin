package participated.abc112

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val (x, y, h) =  Triple(IntArray(n), IntArray(n), IntArray(n))
    for (i in 0 until n) {
        val (xt, yt, ht) = readLine()!!.split(' ').map(String::toInt)
        x[i] = xt
        y[i] = yt
        h[i] = ht
    }
    for (xi in 0..100) {
        for (yi in 0..100) {
            var top = 0
            var flag = true
            for (i in 0 until n) {
                if (h[i] != 0) top = h[i] + Math.abs(x[i] - xi) + Math.abs(y[i] - yi)
            }
            for (i in 0 until n) {
                if (h[i] != Math.max(top - Math.abs(x[i] - xi) - Math.abs(y[i] - yi), 0)) {
                    flag = false
                }
            }
            if (flag) {
                println("$xi $yi $top")
                return
            }
        }
    }
}


//fun past.point100.main(args: Array<String>) {
//    val n = readLine()!!.toLong()
//    val data = mutableMapOf<Pair<Long, Long>, MutableList<Long>>()
//    var count = 0
//    for (i in 1..n) {
//        val (x, y, h) = readLine()!!.split(' ').map(String::toLong)
//        if (h != 0L) {
//            count++
//            for (xi in 0..100) {
//                for (yi in 0..100) {
//                    if (data[Pair(xi.toLong(), yi.toLong())] == null) {
//                        val list = mutableListOf<Long>()
//                        list.add(h + Math.abs(xi - x) + Math.abs(yi - y))
//                        data[Pair(xi.toLong(), yi.toLong())] = list
//                    } else {
//                        data[Pair(xi.toLong(), yi.toLong())]!!.add(h + Math.abs(xi - x) + Math.abs(yi - y))
//                    }
//                }
//            }
//        }
//    }
//    val filterValues = data.filterValues { it.groupBy { it }.maxBy { it.value.size }!!.value.size == count }
//    for (v in filterValues) {
//        println("${v.key.first} ${v.key.second} ${v.value[0]}")
//    }
//}


//fun past.point100.main(args: Array<String>) {
//    val n = readLine()!!.toLong()
//    val data = mutableMapOf<Pair<Long, Long>, Long>()
//    val (x1, y1, h1) = readLine()!!.split(' ').map(String::toLong)
//    for (i in 2..n) {
//        val (x2, y2, h2) = readLine()!!.split(' ').map(String::toLong)
//        if (h1 == h2) {
//            if (y1 != y2) {
//                val a = (x1 - x2).toDouble() / (y2 - y1).toDouble()
//                val b = ((y2 - y1) * (y1 + y2) - (x1 - x2) * (x1 + x2)).toDouble() / (2 * (y2 - y1)).toDouble()
//                for (j in 0..100) {
//                    if (a % 1 == 0.0 && b % 1 == 0.0) {
//                        val second = j * a + b
//                        if (second % 1 == 0.0 && second >= 0) {
//                            val l = (data[Pair(j.toLong(), second.toLong())]
//                                    ?: 0L)
//                            data[Pair(j.toLong(), second.toLong())] = l + 1L
//                        }
//                    }
//                }
//            } else if ((x1 - x2) % 2 == 0L) {
//                for (j in 0..100) {
//                    data[Pair(Math.abs(x1 - x2) / 2, j.toLong())] = (data[Pair(Math.abs(x1 - x2) / 2, j.toLong())]
//                            ?: 0L) + 1L
//                }
//            }
//        } else {
//            if (x1 != x2) {
//                val a = (y2 - y1).toDouble() / (x2 - x1).toDouble()
//                for (j in 0..100) {
//                    val second = a * (j - x1) + y1
//                    if (second % 1 == 0.0) {
//                        if (second >= 0) data[Pair(j.toLong(), second.toLong())] = (data[Pair(j.toLong(), second.toLong())]
//                                ?: 0L) + 1L
//                    }
//                }
//            } else if ((y1 - y2) % 2 == 0L) {
//                for (j in 0..100) {
//                    data[Pair(j.toLong(), Math.abs(y1 - y2) / 2)] = (data[Pair(j.toLong(), Math.abs(y1 - y2) / 2)]
//                            ?: 0L) + 1L
//                }
//            }
//        }
//    }
//    val (pair, value) = data.maxBy { it.value }!!
//    println("${pair.first} ${pair.second} ${h1 + Math.abs(x1 - pair.first) + Math.abs(y1 - pair.second)}")
//}
