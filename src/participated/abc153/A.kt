package participated.abc153

fun main(args: Array<String>) {
    val (h, a) = readLine()!!.split(' ').map(String::toDouble)
    println(Math.ceil(h/a).toInt())
}