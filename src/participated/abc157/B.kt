package participated.abc157

fun main(args: Array<String>) {
    val aMap = (1..3).map { readLine()!!.split(' ').map(String::toInt).toMutableList() }
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val b = readLine()!!.toInt()
        for (j in 0..2)
            for (k in 0..2)
                if (aMap[j][k] == b) aMap[j][k] = 0
    }

    var isBingo = false
    for (j in 0..2) {
        if (aMap[j][0] == 0 && aMap[j][1] == 0 && aMap[j][2] == 0) isBingo = true
        if (aMap[0][j] == 0 && aMap[1][j] == 0 && aMap[2][j] == 0) isBingo = true
    }
    if (aMap[0][0] == 0 && aMap[1][1] == 0 && aMap[2][2] == 0)isBingo = true
    if (aMap[0][2] == 0 && aMap[1][1] == 0 && aMap[2][0] == 0)isBingo = true

    if (isBingo) {
        println("Yes")
    } else {
        println("No")
    }
}
