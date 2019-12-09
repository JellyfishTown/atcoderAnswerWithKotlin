package participated.abc147

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)

    if (a+b+c>21) {
        println("bust")
    } else {
        println("win")
    }
}