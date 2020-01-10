package past.point400

import java.math.BigDecimal
import java.math.BigInteger

//nCk
fun main(args: Array<String>) {
    fun nCk(n: Long, k: Long): Long {
        var mom = BigInteger.valueOf(1)
        var chi = BigInteger.valueOf(1)
        val min = Math.min(k, n - k)
        for (i in 0 until min) {
            mom *= BigInteger.valueOf((min - i))
            chi *= BigInteger.valueOf((n - i))
        }
        return (chi / mom).toLong()
    }
    val (n, a, b) = readLine()!!.split(' ').map(String::toInt)
    val vList = readLine()!!.split(' ').map(String::toLong).sortedDescending()

    val valList = mutableListOf<Pair<Int, BigDecimal>>()
    for (i in a..b) {
        val take = vList.take(i)
        val sum = BigDecimal.valueOf(take.sum())
        val average = sum.setScale(12) / BigDecimal.valueOf(i.toDouble())
        valList.add(Pair(i, average))
    }
    val maxValue = valList.maxBy { it.second }!!.second
    val ansIndexes = valList.filter { it.second == maxValue }.map { it.first }
    var pattern = 0L
    for (i in ansIndexes) {
        val take = vList.take(i)
        val takeLastCount = take.count { it == take.last() }
        val vCount = vList.count { it == take.last() }
        pattern += nCk(vCount.toLong(), takeLastCount.toLong())
    }
    println(maxValue.toPlainString())
    println(pattern)
}

