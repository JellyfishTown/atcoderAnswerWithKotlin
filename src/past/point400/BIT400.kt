package past.point400

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map(String::toInt)
    val xList = readLine()!!.split(' ').map(String::toInt)
    val xSumList = mutableListOf(xList[0])
    (1 until n).forEach { xSumList.add(xSumList.last() + xList[it]) }
    val cList = mutableListOf<Int>()
    val dList = mutableListOf<Int>()
    for (i in 0 until q) {
        val (c, d) = readLine()!!.split(' ').map(String::toInt)
        cList.add(c)
        dList.add(d)
    }


    for (i in 0 until q) {
        fun checkSmaller(num: Int, v: Double): Boolean {
            if (xList.size - 1 < num) return true
            return xList[num] > v
        }

        fun binSearch(v: Double): Int {
            var goalCount = 1 shl 30
            for (j in 29 downTo 0) {
                val diff = 1 shl j
                val currentIndex = goalCount - diff
                if (checkSmaller(currentIndex, v)) {
                    goalCount -= diff
                }
            }
            return goalCount
        }

        val k1 = binSearch((cList[i] - dList[i]).toDouble())
        val k2 = binSearch((cList[i] + 0.1).toDouble())
        val k3 = binSearch((cList[i] + dList[i] + 0.1).toDouble())

        val s1 = k1 * dList[i]
        val s2 = cList[i] * (k2 - k1 + 1) - (xSumList[k2] - xSumList[k1])
        val s3 = xSumList[k3] - xSumList[k2] - cList[i] * (k2 - k1)
        val s4 = (n - k3) * dList[i]
        println(s1 + s2 + s3 + s4)
    }
}

