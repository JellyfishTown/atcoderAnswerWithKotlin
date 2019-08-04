package participated.agc036

fun main(args: Array<String>) {
    val s = readLine()!!.toLong()
    val v = 1000000000L
    val x = (v - s % v) % v
    val y = (s + x) / v
    println(1000000000 * y - x)
    println("0 0 1000000000 1 $x $y")
}
