package participated.abc141

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ')
            .map(String::toLong).sortedDescending()
    var blue = aList[0]
    var red = aList[1]

    for(i in 2 until n){
        val temp1 = (blue xor aList[i]) + red
        val temp2 = (red xor aList[i]) + blue
        if(temp1>temp2){
            blue = blue xor aList[i]
        }else{
            red = red xor  aList[i]
        }
    }
    println(blue + red)


}

//fun main(args: Array<String>) {
//    fun toBinaryNumberCharArray(num: Long, keta: Int): CharArray {
//        return String.format("%0${keta}d", java.lang.Long.toBinaryString(num).toLong()).toCharArray().reversedArray()
//    }
//
//    val keta = 20
//    val n = readLine()!!.toInt()
//    val aList = readLine()!!.split(' ')
//            .map(String::toLong).sortedDescending()
//            .map { toBinaryNumberCharArray(it, keta) }
//    val countKeta = Array(keta) { 0 }
//    for (a in aList) {
//        for (k in 0 until keta) {
//            if(a[k]=='1')countKeta[k]++
//        }
//    }
//    println()
//
//
//}