package point300

fun main(args: Array<String>) {
    var count = 0
    val s = readLine()!!.toCharArray()
    var before = s.first()
    for (i in 1 until s.size) {
        if (before != s[i]) count++
        before = s[i]
    }
    println(count)
}