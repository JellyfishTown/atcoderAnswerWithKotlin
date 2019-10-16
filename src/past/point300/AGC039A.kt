fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val s2 = s + s
    val k = readLine()!!.toLong()
    if (s.toSet().size == 1) {
        println(s.size * k / 2)
        return
    }
    val c1 = (0 until s.size - 1).map {
        if (s[it] == s[it + 1]) run { s[it + 1] = '*' }.let { 1 } else 0
    }.sum()

    val c2 = (0 until s2.size - 1).map {
        if (s2[it] == s2[it + 1]) run { s2[it + 1] = '*' }.let { 1 } else 0
    }.sum()
    println(c1 + (c2 - c1) * (k - 1))
}
