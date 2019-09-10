package past.other.internal

fun main(args: Array<String>) {
    val (x, y, z) = readLine()!!.split(' ').map(String::toLong)
    println(x * 60 * 60 + y * 60 + z)
}
