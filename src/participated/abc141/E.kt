//package participated.abc141
//
////最長部分一致
//fun main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    val s = readLine()!!
//
//    var max = 0
//    for (start in 0 until n) {
//        val z = getZarr()
//    }
//    println(max)
//}
//
//fun getZarr(str: String): IntArray {
//    val n = str.length
//    val Z = IntArray(n)
//    var L = 0
//    var R = 0
//    for (i in 1 until n) {
//        if (i > R) {
//            R = i
//            L = R
//            while (R < n && str[R - L] == str[R]) R++
//            Z[i] = R - L
//            R--
//        } else {
//            val k = i - L
//            if (Z[k] < R - i + 1) {
//                Z[i] = Z[k]
//            } else {
//                L = i
//                while (R < n && str[R - L] == str[R]) R++
//                Z[i] = R - L
//                R--
//            }
//        }
//    }
//    return Z
//}