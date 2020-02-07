package participated.abc152

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)

    if (n == m) {
        println("Yes")
    } else {
        println("No")
    }
}