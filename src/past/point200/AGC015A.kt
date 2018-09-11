package past.point200

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(" ").map(String::toLong)
    if ((n == 1L && a != b) || a > b) {
        println(0)
        return
    }
    val mini = a * (n - 1) + b
    val maxi = a + b * (n - 1)

    println(maxi - mini + 1)
}


