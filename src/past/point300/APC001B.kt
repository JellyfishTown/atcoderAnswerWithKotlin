fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toLong)
    val bList = readLine()!!.split(" ").map(String::toLong)
    val aSum = aList.sum()
    val bSum = bList.sum()
    var e = 0L
    for (i in 0 until n) {
        val sub = bList[i] - aList[i]
        if (sub > 0) e += (sub + 1) / 2
    }
    if (bSum - aSum < e) {
        println("No")
    } else {
        println("Yes")
    }
}