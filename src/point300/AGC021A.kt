fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    when {
        n < 10 -> println(n)
        n.toString()[0] == '1' -> println((n.toString().length - 1) * 9)
        else -> println((n.toString().length - 1) * 9 + n.toString()[0].toString().toInt() - 1)
    }
}