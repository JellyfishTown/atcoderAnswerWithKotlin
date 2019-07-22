package participated.abc131

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xySet = mutableSetOf<Pair<Int, Int>>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        xySet.add(Pair(a, b))
    }
    val xMap = mutableMapOf<Int, MutableList<Int>>()
    val yMap = mutableMapOf<Int, MutableList<Int>>()

    for ((x, y) in xySet) {
        if (xMap.containsKey(x)) {
            xMap[x]!!.add(y)
        } else {
            xMap[x] = mutableListOf(y)
        }
        if (yMap.containsKey(y)) {
            yMap[y]!!.add(x)
        } else {
            yMap[y] = mutableListOf(x)
        }
    }


    var xySize = xySet.size
    var count = 0L
    for ((x, yList) in xMap) {
        if (yList.size <= 1) continue

        for (i in 0 until yList.size - 1) {
            for (j in i + 1 until yList.size) {
                val y1 = yList[i]
                val y2 = yList[j]
                var xList = xMap[y1] ?: mutableListOf()
                if (xList.size >= 1) {
                    for (k in xList) {
                        if (k == x) continue
                        xySet.add(Pair(k, y2))
                        if (xySize != xySet.size) {
                            count++
                            xySize = xySet.size
                        }
                    }
                }
                xList = xMap[y2] ?: mutableListOf()
                if (xList.size >= 1) {
                    for (k in xList) {
                        if (k == x) continue
                        xySet.add(Pair(k, y1))
                        if (xySize != xySet.size) {
                            count++
                            xySize = xySet.size
                        }
                    }
                }
            }
        }
    }
    println(count)
}