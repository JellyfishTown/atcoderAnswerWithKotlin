fun main(args: Array<String>) {
    val (a, b, c, k) = readLine()!!.split(" ").map(String::toLong)
    println(if (k % 2 == 0L) a - b else b - a)
}
