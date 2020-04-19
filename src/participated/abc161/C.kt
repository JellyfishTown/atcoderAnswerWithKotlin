package participated.abc161

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val mod = n % k
    val min = Math.min(mod, k - mod)
    println(min)
}
