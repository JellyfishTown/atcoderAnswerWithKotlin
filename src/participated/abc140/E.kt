package participated.abc140

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toLong)
    var ans = 0L
    for (i in 0 until n) {
        val curVal = pList[i]
        var li = -1
        var ri = -1
        for (j in i - 1 downTo 0) {
            if (pList[j] > curVal) {
                li = j
                break
            }
        }
        for (j in i + 1 until n) {
            if (pList[j] > curVal) {
                ri = j
                break
            }
        }
        if (li == -1 && ri == -1) {
            //do nothing
        } else if (li == -1) {
            ans += (i + 1) * curVal
        } else if (ri == -1) {
            ans += (n - i) * curVal
        } else {
            ans += (i + 1) * curVal
            ans += (n - i) * curVal
        }
    }

    println(ans)
}

//fun past.point100.past.point300.main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    val pList = readLine()!!.split(' ').map(String::toLong)
//    var ans = 0L
//    for (l in 0 until n - 1) {
//        for (r in l + 1 until n) {
//            ans += pList.subList(l, r + 1).sortedDescending()[1]
//        }
//    }
//    println(ans)
//}
