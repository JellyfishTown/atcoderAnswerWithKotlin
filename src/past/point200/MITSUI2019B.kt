package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 1..50000) {
        if ((i.toDouble() * 1.08).toInt() == n) {
            println(i)
            return
        }
    }
    println(":(")
}
