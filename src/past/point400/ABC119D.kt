package past.point400

fun main(args: Array<String>) {
    val (a, b, q) = readLine()!!.split(' ').map(String::toInt)
    val aList = DoubleArray(a) { readLine()!!.toDouble() }.sorted().toTypedArray()
    val bList = DoubleArray(b) { readLine()!!.toDouble() }.sorted().toTypedArray()
    val xList = DoubleArray(q) { readLine()!!.toDouble() }
    for (x in xList) {
        val ta = aList.search(x)
        val ra = if (ta == a) -1 else ta
        val la = if (ra == -1) a - 1 else if (ra == 0) -1 else ra - 1
        val tb = bList.search(x)
        val rb = if (tb == b) -1 else tb
        val lb = if (rb == -1) b - 1 else if (rb == 0) -1 else rb - 1

        var min = Long.MAX_VALUE
        if (ra >= 0 && rb >= 0) min = Math.min(min, Math.max(aList[ra], bList[rb]).toLong() - x.toLong())
        if (la >= 0 && lb >= 0) min = Math.min(min, x.toLong() -  Math.min(aList[la], bList[lb]).toLong())
        if (ra >= 0 && lb >= 0) min = Math.min(min, (aList[ra] - x + aList[ra] - x + x - bList[lb]).toLong())
        if (rb >= 0 && la >= 0) min = Math.min(min, (bList[rb] - x + bList[rb] - x + x - aList[la]).toLong())
        if (la >= 0 && rb >= 0) min = Math.min(min, (x - aList[la] + x - aList[la] + bList[rb] - x).toLong())
        if (ra >= 0 && lb >= 0) min = Math.min(min, (x - bList[lb] + x - bList[lb] + aList[ra] - x).toLong())
        println(min)
    }

}

fun Array<Double>.search(target: Double, d: Double = 0.0000001): Int {
    val binarySearch = this.binarySearch(target - d)
    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
}
