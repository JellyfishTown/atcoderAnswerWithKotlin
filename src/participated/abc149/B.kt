package participated.abc149

fun main(args: Array<String>) {
    val (a, b, k) = readLine()!!.split(' ').map(String::toLong)

    if (a > k) {
        println("${a - k} $b")
    } else {
        println("0 ${Math.max(b - k + a, 0)}")
    }
}