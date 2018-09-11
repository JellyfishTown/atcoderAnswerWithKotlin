package past.point300

fun main(args: Array<String>) {
    val (n,y) = readLine()!!.split(" ").map(String::toInt)
    for (i in 0..n) {
        if (i * 10000 > y) continue
        for (j in 0..n) {
            if (i * 10000 + j * 5000 > y) continue
            val sa = y - (i * 10000 + j * 5000)
            val k = sa / 1000
            if (i + j + k == n) {
                println("$i $j $k")
                return
            }
        }
    }
    println("-1 -1 -1")
}
