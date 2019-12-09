package participated.abc146

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()
    val i = s.map { it.toInt() + n }
    val c = i.map {
        if (it.toChar() in "ABCDEFGHIJKLMNOPQRSTUVWXYZ") {
            it.toChar()
        } else {
            (it - 26).toChar()
        }
    }
    println(c.joinToString(""))
}