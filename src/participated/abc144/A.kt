package participated.abc144

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)

    if (a<=9&&b<=9) {
        println(a*b)
    } else {
        println(-1)
    }
}