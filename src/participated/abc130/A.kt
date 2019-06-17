package participated.abc130

fun main(args: Array<String>) {
    val (x, a) = readLine()!!.split(' ').map(String::toLong)
    println(if (x < a) 0 else 10)
}
