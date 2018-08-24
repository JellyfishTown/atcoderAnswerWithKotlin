package point200

fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val x = readLine()!!.toInt()
    var count = 0
    for (i in 0..a) {
        if (i * 500 > x) continue
        for (j in 0..b) {
            if (i * 500 + j * 100 > x) continue
            val sa = x - (i * 500 + j * 100)
            if (sa == 0) {
                count++
            } else if (sa / 50 <= c) {
                count++
            }
        }
    }
    println(count)
}
