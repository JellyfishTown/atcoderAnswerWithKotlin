package participated.abc133

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    println(Math.min(n*a,b))
}
