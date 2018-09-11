fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    when {
        n < 10 -> println(n)
        n.toString().substring(1,n.toString().length).all { it == '9' } -> println((n.toString().length - 1) * 9 + n.toString()[0].toString().toInt())
        n.toString()[0] == '1' -> println((n.toString().length - 1) * 9)
        else -> println((n.toString().length - 1) * 9 + n.toString()[0].toString().toInt() - 1)
    }
}