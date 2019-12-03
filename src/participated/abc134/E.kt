package participated.abc134

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = IntArray(n) { 0 }
    (1..n).forEach { aList[it - 1] = readLine()!!.toInt() }
    val ansArray = IntArray(n) { Int.MAX_VALUE }
    var count = 0

    for (i in 0 until n) {
        val a = aList[i]
        if (a > ansArray.getOrNull(count - 1) ?: Int.MAX_VALUE) {
            var l = 0
            var r = count
            var mid = (l + r) / 2
            while (true) {
                if (ansArray[mid] < a && ansArray.getOrNull(mid - 1) ?: Int.MAX_VALUE >= a) {
                    ansArray[mid] = a
                    break
                } else if (ansArray[mid] < a) {
                    r = mid
                } else {
                    l = mid
                }
                mid = (l + r) / 2
            }
        } else {
            ansArray[count++] = a
        }
    }
    println(count)
}


//fun past.point100.main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    val aList = mutableListOf<Int>()
//    (1..n).forEach { aList.add(readLine()!!.toInt()) }
//    val ansList = mutableListOf<Int>()
//    var min = Int.MAX_VALUE
//
//    for (i in 0 until n) {
//        val a = aList[i]
//        if (a > min) {
//            val array = ansList.toTypedArray()
//            val i1 = Math.abs(array.binarySearch(a))-2
//            ansList[i1] = a
//            min = ansList[0]
//        } else {
//            ansList.add(0,a)
//            min = a
//        }
//    }
//    println(ansList.size)
//}
//
//
//fun Array<Int>.lowerBound(target: Int, d: Int = 1): Int {
//    val binarySearch = this.binarySearch(target - d)
//    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
//}
