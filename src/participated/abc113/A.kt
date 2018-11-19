package participated.abc113

fun main(args: Array<String>) {
    val (x, y) = readLine()!!.split(' ').map(String::toLong)
    println(x + y / 2)
}
