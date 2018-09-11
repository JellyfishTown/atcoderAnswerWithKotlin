package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val lucas = mutableListOf(2L, 1L)
    for (i in 2..n) {
        lucas.add(lucas[i - 1] + lucas[i - 2])
    }
    println(lucas[n])
}
