fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val tList = mutableListOf<Int>()
    val xList = mutableListOf<Int>()
    val yList = mutableListOf<Int>()
    for (i in 1..n) {
        val list = readLine()!!.split(" ").map(String::toInt)
        tList.add(list[0])
        xList.add(list[1])
        yList.add(list[2])
    }

    var currentT = 0
    var currentX = 0
    var currentY = 0

    for (i in 0..(n - 1)) {
        val distance = calcDistance(currentX, currentY, xList[i], yList[i])
        val timeDistance = tList[i] - currentT
        if (distance <= timeDistance && checkSame(distance, timeDistance)) {
        } else {
            println("No")
            return
        }
        currentT = tList[i]
        currentX = xList[i]
        currentY = yList[i]
    }

    println("Yes")
}

fun calcDistance(x1: Int, y1: Int, x2: Int, y2: Int) = Math.abs(x1 - x2) + Math.abs(y1 - y2)
fun checkSame(v1: Int, v2: Int) = (v1 % 2 == 0 && v2 % 2 == 0) || (v1 % 2 == 1 && v2 % 2 == 1)