package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    var count = 0
    var sameFlag = true
    for (i in 0..(n - 2)) {
        if (aList[i] == aList[i + 1] && sameFlag) {
            count++
            sameFlag = !sameFlag
        } else {
            sameFlag = true
        }
    }
    println(count)
}