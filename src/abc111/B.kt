package abc111

fun main(args: Array<String>) {
    val data = readLine()!!.toLong()
    for (i in 1..9) {
        if (i * 111 >= data) {
            println(i * 111)
            return
        }
    }
}


