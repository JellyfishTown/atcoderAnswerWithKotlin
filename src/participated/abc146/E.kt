package participated.abc146

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val aSumList = mutableListOf(aList[0])
    (1 until n).forEach { aSumList.add(aSumList.last() + aList[it.toInt()]) }

    var ans = 0L
//    for (l in (0..n - 1)) {
//        for (r in (l + 1..n)) {
//            val subList = aList.subList(l.toInt(), r.toInt() )
//            val sum = subList.sum()
//            val mod = sum % k
//            if (mod.toInt() == subList.size) {
////                println(subList.joinToString(" "))
//                ans++
//            }
//        }
//    }

    println(ans)
}