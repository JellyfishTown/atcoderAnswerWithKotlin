fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray().map { it.toInt() }
    var count = 1L
    var cur = s[0]
    for (i in 1 until s.size) {
        if (s[i] <= cur) {
            cur = s[i]
            count++
        }
    }
    println(count)
}

