package participated.abc158

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    val div = n / (a + b)
    val left = n - div * (a + b)
    if (left >= a) {
        println(div * a + a)
    } else {
        println(div * a + left)
    }
}
