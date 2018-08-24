
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 0..(n / 7)) {
        if ((n - i * 7) % 4 == 0) {
            println("Yes")
            return
        }
    }
    println("No")
}
