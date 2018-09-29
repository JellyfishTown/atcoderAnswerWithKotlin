fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    var mode = 0
    var count = 1

    for (i in 0 until n - 1) {
        if (mode == 0) {
            if (aList[i] < aList[i + 1]) {
                mode = 1
            } else if (aList[i] > aList[i + 1]) {
                mode = -1
            }
        } else if (mode == 1) {
            if (aList[i] > aList[i + 1]) {
                mode = 0
                count++
            }
        } else {
            if (aList[i] < aList[i + 1]) {
                mode = 0
                count++
            }
        }
    }
    println(count)
}

