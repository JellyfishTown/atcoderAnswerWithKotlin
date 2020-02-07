package participated.abc150

fun main(args: Array<String>) {
    val n = readLine()!!
    val s = readLine()!!
    println((0 until s.length - 2).count {
        s[it] == 'A' && s[it + 1] == 'B' && s[it + 2] == 'C'
    })
}