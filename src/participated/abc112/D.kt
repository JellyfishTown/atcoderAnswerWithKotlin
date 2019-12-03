package participated.abc112

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    for (a in m / n downTo 1) {
        if (m % a == 0L && a * n <= m) {
            println(a)
            return
        }
    }
}

//fun past.point100.main(args: Array<String>) {
//    val (n, m) = readLine()!!.split(' ').map(String::toLong)
//    var ans = 1L
//    for (a in 1L..(Math.sqrt(m.toDouble())).toLong()) {
//        if (m % a != 0L) continue
//        val b = m / a
//        if (a * n <= m) ans = Math.max(ans, a)
//        if (b * n <= m) ans = Math.max(ans, b)
//    }
//    println(ans)
//}
