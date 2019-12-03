package past.point600

fun main(args: Array<String>) {
    val (t1, t2) = readLine()!!.split(' ').map(String::toLong)
    val (a1, a2) = readLine()!!.split(' ').map(String::toLong)
    val (b1, b2) = readLine()!!.split(' ').map(String::toLong)
    val (v1, v2) = Pair(a1 - b1, a2 - b2)
    val (d1, d2) = Pair(v1 * t1, v2 * t2)
    if (d1 + d2 == 0L) {
        println("infinity")
    } else if (v1 > 0 && v2 > 0) {
        println("0")
    } else if (v1 < 0 && v2 < 0) {
        println("0")
    } else if (d1 < 0L) {
        val s = (-d1) / (d1 + d2)
        val t = (-d1) % (d1 + d2)
        if (t == 0L) {
            println(s * 2)
        } else {
            println(s * 2 + 1)
        }
    } else {
        val s = (d1) / (-d1 - d2)
        val t = (d1) % (-d1 - d2)
        if (t == 0L) {
            println(s * 2)
        } else {
            println(s * 2 + 1)
        }
    }
}
