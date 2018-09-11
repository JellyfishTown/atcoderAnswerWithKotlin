package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val heiho = mutableListOf(1)
    for (i in 2..40000) {
        heiho.add(i * i)
    }
    println(heiho.last { it <= n })
}
