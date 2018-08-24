package point200

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ")
    val num = (a + b).toInt()
    for (i in 4..1000) {
        if (i * i == num) {
            println("Yes")
            return
        }
    }
    println("No")
}
