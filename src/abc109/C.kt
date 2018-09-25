package abc109

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(' ').map(String::toLong)
    val xList = readLine()!!.split(' ').map { Math.abs(it.toLong() - x) }
    println(gcd(xList))
}

fun gcd(a: Long, b: Long): Long {
    var tempA = a
    var tempB = b
    if (tempA < tempB) {
        val tmp = tempA
        tempA = tempB
        tempB = tmp
    }
    var r = -1L
    while (r != 0L) {
        r = tempA % tempB
        tempA = tempB
        tempB = r
    }
    return tempA
}

fun gcd(param: List<Long>): Long {
    val len = param.size
    if (len == 1) return param[0]
    var g = gcd(param[0], param[1])
    for (i in 1 until len - 1) {
        g = gcd(g, param[i + 1])
    }
    return g
}
