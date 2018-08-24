package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var (currentT, currentA) = Pair(1L, 1L)

    for (i in 1..n) {
        val (t, a) = readLine()!!.split(' ').map(String::toLong)
        if (t >= currentT && a >= currentA) {
            currentT = t
            currentA = a
            continue
        }
        val tDiv = currentT / t + if (currentT % t == 0L) 0 else 1
        val aDiv = currentA / a + if (currentA % a == 0L) 0 else 1
        currentT = t * if (tDiv > aDiv) tDiv else aDiv
        currentA = a * if (tDiv > aDiv) tDiv else aDiv
    }
    println(currentT + currentA)
}