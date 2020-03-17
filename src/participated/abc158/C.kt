package participated.abc158

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)

    for (i in 10..1000) {
        if (i * 8 / 100 == a && i * 10 / 100 == b) {
            println(i)
            return
        }
    }
    println(-1)
}
