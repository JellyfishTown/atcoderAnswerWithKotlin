package abc106

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var count = 0
    for (i in 1..n) {
        if (i % 2 == 0) continue
        var tempCount = 0
        for (j in 1..i) {
            if (i % j == 0) tempCount++
        }
        if (tempCount == 8) count++
    }
    println(count)
}


