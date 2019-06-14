package past.point400

fun main(args: Array<String>) {
    fun toBinaryNumberCharArray(num: Long, keta: Int): CharArray {
        return String.format("%${keta}s", java.lang.Long.toBinaryString(num)).replace(" ", "0").toCharArray()
                .reversedArray()
    }

    val keta = 41
    val twoPow = (0..keta).map { it to Math.pow(2.0, it.toDouble()).toLong() }.toMap()

    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map { toBinaryNumberCharArray(it.toLong(), keta) }
    val standCount = IntArray(keta) { 0 }
    aList.forEach { a -> (0 until keta).forEach { if (a[it] == '1') standCount[it]++ } }
    val kBin = toBinaryNumberCharArray(k, keta)

    val dp = Array(keta + 1) { Array(2) { 0L } }//dp[keta][上位桁が全部一致フラグ]
    for (i in (keta - 1) downTo 0) {
        val stand = standCount[i]
        val notStand = n.toInt() - stand
        if (kBin[i] == '1') {
            dp[i][0] = Math.max(
                    dp[i + 1][1] + notStand * twoPow[i]!!, Math.max(
                    dp[i + 1][0] + notStand * twoPow[i]!!,
                    dp[i + 1][0] + stand * twoPow[i]!!)
            )
            dp[i][1] = dp[i + 1][1] + notStand * twoPow[i]!!
        } else {
            dp[i][0] = Math.max(dp[i + 1][0] + notStand * twoPow[i]!!,
                    dp[i + 1][0] + stand * twoPow[i]!!)
            dp[i][1] = dp[i + 1][1] + stand * twoPow[i]!!
        }
    }
    println(Math.max(dp[0][0], dp[0][1]))
}
