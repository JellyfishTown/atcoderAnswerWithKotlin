package participated.abc130

fun main(args: Array<String>) {
    val (w, h, x, y) = readLine()!!.split(' ').map(String::toLong)
    val multi = if (w == x * 2 && h == y * 2) 1 else 0
    println("${(w * h).toDouble() / 2.0} $multi")
}
