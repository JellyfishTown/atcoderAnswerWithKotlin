package participated.abc161

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)
    println("$c $a $b")
}
