package participated.ext010

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    println(if (k == 1L) 0 else n - k)
}
