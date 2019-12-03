//package participated.agc029
//
//fun past.point100.main(args: Array<String>) {
//    val n = readLine()!!.toLong()
//    val aList = readLine()!!.split(' ').map(String::toLong).sorted().toMutableList()
//
//    val bekiList = mutableListOf<Long>()
//    var temp = 2L
//    while (temp < 2000000000) {
//        bekiList.add(temp)
//        temp *= 2
//    }
//    bekiList.reverse()
//
//    var pair = 0L
//    while (true) {
//        if (aList.size <= 1) break
//        val p1 = aList.last()
//        aList.removeAt(aList.size - 1)
//        for (beki in bekiList) {
//            val first = participated.agc030.fastIndexOfFirst { it == beki - p1 }
//            if (first != -1) {
//                pair++
//                aList.removeAt(first)
//                break
//            }
//        }
//    }
//    print(pair)
//}
//
//
//inline fun <T> List<T>.fastIndexOfFirst(predicate: (T) -> Boolean): Int {
//    var left = 0
//    var right = size - 1
//    if(predicate(this[left])){
//        return left
//    }
//    var allFalse = true
//    while (left < right) {
//        val index = ((left + right) / 2)
//        if (predicate(this[index])) {
//            right = index
//            allFalse = false
//        } else {
//            left = index + 1
//        }
//    }
//    return when {
//        predicate(this[left]) -> left
//        allFalse -> return -1
//        else -> left - 1
//    }
//}
