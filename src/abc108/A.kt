package abc108

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    println((k / 2) * (k / 2 + if (k % 2 == 0) 0 else 1))
}
