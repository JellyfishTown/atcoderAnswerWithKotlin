package participated.abc151

import java.lang.Exception

fun main(args: Array<String>) {
    fun calcDist(one: Pair<Double, Double>, two: Pair<Double, Double>) =
            Math.sqrt(Math.pow(one.first - two.first, 2.0) + Math.pow(one.second - two.second, 2.0))

    fun calcCenter(one: Pair<Double, Double>, two: Pair<Double, Double>, three: Pair<Double, Double>): Pair<Double, Double> {
        val a = two.first - one.first
        val b = two.second - one.second
        val c = three.first - one.first
        val d = three.second - one.second

        if ((a * d - b * c) == 0.0) {
            val maxx = Math.max(one.first, Math.max(two.first, three.first))
            val minx = Math.min(one.first, Math.min(two.first, three.first))
            val maxy = Math.max(one.second, Math.max(two.second, three.second))
            val miny = Math.min(one.second, Math.min(two.second, three.second))
            return Pair((maxx + minx) / 2.0, (maxy + miny) / 2.0)
        }

        val ox =
                if (a == 0.0 && c == 0.0) {
                    one.first
                } else {
                    one.first + (d * (a * a + b * b) - b * (c * c + d * d)) / (a * d - b * c) / 2.0
                }
        val oy =
                if (b != 0.0) {
                    (a * (one.first + two.first - ox - ox) + b * (one.second + two.second)) / b / 2.0;
                } else if (d != 0.0) {
                    (c * (one.first + three.first - ox - ox) + d * (one.second + three.second)) / d / 2.0;
                } else {
                    one.second
                }
        return Pair(ox, oy)
    }


    val n = readLine()!!.toInt()
    val xyList = mutableListOf<Pair<Double, Double>>()
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toInt)
        xyList.add(Pair(x.toDouble(), y.toDouble()))
    }
    if (n == 2) {
        println(calcDist(xyList[0], xyList[1]) / 2.0)
        return
    }

    var minDist = Double.MAX_VALUE
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                try {
                    val center = calcCenter(xyList[i], xyList[j], xyList[k])
                    if (center.first.isNaN() || center.second.isNaN()
                            || center.first.isInfinite() || center.second.isInfinite()) continue
                    var harfDist = calcDist(xyList[i], center)
                    harfDist = Math.max(harfDist, calcDist(xyList[j], center))
                    harfDist = Math.max(harfDist, calcDist(xyList[k], center))
                    if (xyList.all { calcDist(it, center) <= harfDist }) {
                        minDist = Math.min(minDist, harfDist)
                    }
                } catch (e: Exception) {
//                    do nothing
                }
            }
        }
    }
    for (i in 0 until n - 1) {
        for (j in 1 until n) {
            val calcDist = calcDist(xyList[i], xyList[j])
            val harfDist = calcDist/2.0
            val center = Pair((xyList[i].first + xyList[j].first) / 2.0,
                    (xyList[i].second + xyList[j].second) / 2.0)
            if (xyList.all { calcDist(it, center) <= harfDist }) {
                minDist = Math.min(minDist, calcDist)
            }
        }
    }
    println(minDist)
}

