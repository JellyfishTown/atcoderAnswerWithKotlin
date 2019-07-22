package participated.abc133

fun main(args: Array<String>) {
    fun calcDist(l1: List<Double>, l2: List<Double>): Double {
        var sum = 0.0
        for (i in 0 until l1.size) {
            sum += (l1[i] - l2[i]) * (l1[i] - l2[i])
        }
        return Math.sqrt(sum)
    }
    val (n, d) = readLine()!!.split(' ').map(String::toInt)
    val xListList = mutableListOf<List<Double>>()
    (1..n).forEach { xListList.add(readLine()!!.split(' ').map(String::toDouble)) }

    var count = 0
    for (i in 0 until n - 1) {
        val xList1 = xListList[i]
        for (j in i + 1 until n) {
            val xList2 = xListList[j]
            val dist = calcDist(xList1, xList2)
            if (dist % 1 == 0.0) {
                count++
            }
        }
    }

    println(count)
}

