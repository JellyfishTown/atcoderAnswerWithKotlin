package past.point400

fun main(args: Array<String>) {
    fun toBinaryNumberCharArray(num: Long, keta: Int): CharArray {
        return String.format("%0${keta}d", java.lang.Long.toBinaryString(num).toLong()).toCharArray().reversedArray()
    }

    val keta = 40
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map { toBinaryNumberCharArray(it.toLong(), keta) }
    val standCount = IntArray(keta) { 0 }
    aList.forEach { a -> (0 until keta).forEach { if (a[it] == '1') standCount[it]++ } }
    val k2 = toBinaryNumberCharArray(k, keta)

    val dp = Array(keta) { Array(2) { "" } }//dp[keta][上位桁が全部一致フラグ]
    var hasValue = false
    for (i in (keta - 1) downTo 0) {
        if (k2[keta] == '1') hasValue = true
        if (!hasValue) continue


    }
    val a = 1L
}
//            hasValue = true
//            if(n.toDouble() / 2.0 >= standCount[keta].toDouble()){
//                dp[keta][1]= "1"
//            }else{
//
//            }
