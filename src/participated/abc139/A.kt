package participated.abc139

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    println((0..2).count { s[it]==t[it] })
}
