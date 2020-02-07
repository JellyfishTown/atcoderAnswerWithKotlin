package past.other.past

fun main(args: Array<String>) {
    println(try {
        readLine()!!.toInt() * 2
    } catch (e: NumberFormatException) {
        "error"
    })
}
