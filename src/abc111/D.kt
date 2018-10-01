package abc111

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xList = mutableListOf<Long>()
    val yList = mutableListOf<Long>()
    var max = 0L
    for (i in 1..n) {
        val (x, y) = readLine()!!.split(' ').map(String::toLong)
        xList.add(x)
        yList.add(y)
        max = Math.max(Math.abs(x) + Math.abs(y), max)
    }

    for (i in 0 until n) {
        if ((max - Math.abs(xList[i]) - Math.abs(yList[i])) % 2 == 1L) {
            println(-1)
            return
        }
    }

    println(max)
    for( i in 1..max.toInt())print("")
    println()
    for (i in 0 until n) {
        if (xList[i] > 0) {
            for( j in 1..xList[i].toInt())print('R')
        } else if (xList[i] < 0) {
            for( j in 1..Math.abs(xList[i].toInt()))print('L')
        }
        if (yList[i] > 0) {
            for( j in 1..yList[i].toInt())print('U')
        } else if (yList[i] < 0) {
            for( j in 1..Math.abs(yList[i].toInt()))print('D')
        }
        for (j in 1..((max - Math.abs(xList[i]) - Math.abs(yList[i])) / 2)) {
            print("RL")
        }
        println()
    }
}
