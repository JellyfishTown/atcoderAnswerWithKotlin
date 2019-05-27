package participated.abc127

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    if (a <= 5) {
        println(0)
    } else if (a <= 12) {
        println(b / 2)

    } else {
        println(b)
    }
}
