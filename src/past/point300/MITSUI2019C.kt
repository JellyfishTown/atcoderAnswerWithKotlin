package past.point300

fun main(args: Array<String>) {
    val x = readLine()!!.toInt()
    val num = x / 100
    val mod = x % 100
    if (num >= 20 || num * 5 >= mod) {
        println(1)
    } else {
        println(0)
    }
}
