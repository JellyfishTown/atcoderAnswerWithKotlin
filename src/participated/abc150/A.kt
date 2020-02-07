package participated.abc150

fun main(args: Array<String>) {
    val (k, x) = readLine()!!.split(' ').map(String::toLong)

    if (k * 500 >= x) {
        println("Yes")
    } else {
        println("No")
    }
}