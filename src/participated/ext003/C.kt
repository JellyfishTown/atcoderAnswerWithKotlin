package participated.ext003


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val bList = readLine()!!.split(' ').map(String::toLong)
    val aSum = aList.sum()
    val bSum = bList.sum()
    if (aSum < bSum) {
        println(-1)
        return
    }
    val diffList = (0 until n).map { aList[it] - bList[it] }.sortedDescending()
    val minusDiffList = diffList.filter { it < 0 }
    val minusCount = minusDiffList.size
    val minusSum = minusDiffList.sum()
    var offsetSum = 0L
    if (minusCount == 0) {
        print(0)
    } else {
        for (i in 0..diffList.size) {
            offsetSum += diffList[i]
            if (offsetSum >= - minusSum) {
                print(minusCount + i + 1)
                return
            }
        }
    }
}
