package past.point300

fun main(args: Array<String>) {
    val s = readLine()!!
    println(Math.max((s.count { it == 'g' } - s.count { it == 'p' }) / 2, 0))
}