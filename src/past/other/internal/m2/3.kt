package past.other.internal.m2

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xRatioList = mutableListOf<Map<Int, Double>>()//i個目の箱でxが出る確率
    val xSet = mutableSetOf<Int>()//箱の中に存在する全てのxの一覧
    (1..n).forEach {
        val input = readLine()!!.split(' ').map(String::toInt)
        val m = input[0]
        val xList = input.takeLast(m)
        xSet.addAll(xList)

        val xRatio = mutableMapOf<Int, Double>()
        xList.toSet().forEach { x ->
            xRatio[x] = xList.count { l -> l == x }.toDouble() / m.toDouble()//この箱でxが出る確率
        }
        xRatioList.add(xRatio)
    }

    val ans = mutableListOf<MutableMap<Int, Double>>()//i個目の箱を開けた時点でxが1個以上存在する確率
    for (i in 1..n) {
        val ansMap = mutableMapOf<Int, Double>()
        xSet.forEach { ansMap[it] = 0.0 }

        val xRatio = xRatioList[i - 1]
        for (x in xSet) {
            ansMap[x] = (ans.lastOrNull()?.get(x) ?: 0.0)
            +(1 - (ans.lastOrNull()?.get(x) ?: 0.0)) * (xRatio[x] ?: 0.0)
        }
        ans.add(ansMap)
    }
    println(ans.last().values.sum())
}
