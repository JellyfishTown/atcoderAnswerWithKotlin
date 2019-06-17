package participated.abc130

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var maxXUD = -Double.MAX_VALUE / 2
    var maxXR = -Double.MAX_VALUE / 2
    var maxXL = -Double.MAX_VALUE / 2

    var minXUD = Double.MAX_VALUE / 2
    var minXR = Double.MAX_VALUE / 2
    var minXL = Double.MAX_VALUE / 2

    var maxYRL = -Double.MAX_VALUE / 2
    var maxYU = -Double.MAX_VALUE / 2
    var maxYD = -Double.MAX_VALUE / 2

    var minYRL = Double.MAX_VALUE / 2
    var minYU = Double.MAX_VALUE / 2
    var minYD = Double.MAX_VALUE / 2
    (0 until n).forEach {
        val (tx, ty, d) = readLine()!!.split(' ')
        val x = tx.toDouble()
        val y = ty.toDouble()
        when (d) {
            ("R") -> {
                if (maxXR < x) maxXR = x
                if (minXR > x) minXR = x
                if (maxYRL < y) maxYRL = y
                if (minYRL > y) minYRL = y
            }
            ("L") -> {
                if (maxXL < x) maxXL = x
                if (minXL > x) minXL = x
                if (maxYRL < y) maxYRL = y
                if (minYRL > y) minYRL = y
            }
            ("U") -> {
                if (maxXUD < x) maxXUD = x
                if (minXUD > x) minXUD = x
                if (maxYU < y) maxYU = y
                if (minYU > y) minYU = y
            }
            ("D") -> {
                if (maxXUD < x) maxXUD = x
                if (minXUD > x) minXUD = x
                if (maxYD < y) maxYD = y
                if (minYD > y) minYD = y
            }
        }

    }
    var maxX = Math.max(maxXL, Math.max(maxXR, maxXUD))
    var minX = Math.min(minXL, Math.min(minXR, minXUD))
    var maxY = Math.max(maxYRL, Math.max(maxYU, maxYD))
    var minY = Math.min(minYU, Math.min(minYD, minYRL))
    var min = (maxX - minX) * (maxY - minY)

    var d = 10000000.0
    while (true) {
        maxXL -= d
        minXL -= d
        maxXR += d
        minXR += d
        maxYD -= d
        minYD -= d
        maxYU += d
        minYU += d
        maxX = Math.max(maxXL, Math.max(maxXR, maxXUD))
        minX = Math.min(minXL, Math.min(minXR, minXUD))
        maxY = Math.max(maxYRL, Math.max(maxYU, maxYD))
        minY = Math.min(minYU, Math.min(minYD, minYRL))
        if (min > (maxX - minX) * (maxY - minY)) {
            min = (maxX - minX) * (maxY - minY)
        } else {
            if (d <= 0.01) break
            maxXL +=  d
            minXL +=  d
            maxXR -=  d
            minXR -=  d
            maxYD +=  d
            minYD +=  d
            maxYU -=  d
            minYU -=  d
            d /= 10
        }
    }
    println(min)
}
