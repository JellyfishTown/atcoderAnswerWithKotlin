package abc110

fun main(args: Array<String>) {
    val data = readLine()!!.split(' ').sorted()
    println((data[2] + data[1]).toInt() + data[0].toInt())
}
