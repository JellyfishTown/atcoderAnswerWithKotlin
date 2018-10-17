package abc112

fun main(args: Array<String>) {
    val num = readLine()!!.toLong()
    if (num == 1L) {
        println("Hello World")
    } else {
        val a = readLine()!!.toLong()
        val b = readLine()!!.toLong()
        println(a + b)
    }
}
