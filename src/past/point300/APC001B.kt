fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toLong)
    val bList = readLine()!!.split(" ").map(String::toLong)
    val aSum = aList.sum()
    val bSum = bList.sum()
    var aNum = 0L
    var bNum = 0L
    for (i in 0 until n) {
        if (bList[i] < aList[i]) {
            bNum += aList[i] - bList[i]
        } else {
            aNum += bList[i] - aList[i]
        }
    }
    println(if ((bNum <= (bSum - aSum)) && (aNum <= (bSum - aSum) * 2)) "Yes" else "No")
}