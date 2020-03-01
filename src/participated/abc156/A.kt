package participated.abc156

fun main(args: Array<String>) {
    val (n, r) = readLine()!!.split(' ').map(String::toLong)

    if (n >= 10) {
        println(r)
    } else {
        println(r + 100 * (10 - n))
    }
}
