package participated.ext006

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    if (s.count { it == 'R' } > s.count { it == 'B' }) {
        println("Yes")
    } else {
        println("No")
    }
}
