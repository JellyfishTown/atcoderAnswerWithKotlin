package participated.abc135

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    val bList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    var total = 0L

    for (i in (n - 1) downTo 0) {
        if (aList[i + 1] >= bList[i]) {
            total += bList[i]
            aList[i + 1] -= bList[i]
            bList[i] = 0
        } else {
            total += aList[i + 1]
            bList[i] -= aList[i + 1]
            aList[i + 1] = 0
        }

        if (aList[i] >= bList[i]) {
            total += bList[i]
            aList[i] -= bList[i]
            bList[i] = 0
        } else {
            total += aList[i]
            bList[i] -= aList[i]
            aList[i] = 0
        }
    }

    println(total)
}