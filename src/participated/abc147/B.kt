package participated.abc147

fun main(args: Array<String>) {
    val s = readLine()!!
    println((0 until s.length / 2).map { if (s[it] != s[s.length - 1 - it]) 1 else 0 }.sum())
}