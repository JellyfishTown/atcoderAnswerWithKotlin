package participated.agc029

fun main(args: Array<String>) {
    val s = readLine()!!
    var bCount = 0L
    var total = 0L
    for (c in s) {
        if (c == 'B') {
            bCount++
        } else {
            total += bCount
        }
    }
    println(total)
}

