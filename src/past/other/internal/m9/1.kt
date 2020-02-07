package past.other.internal.m9

fun main(args: Array<String>) {
    val s = 'a' + readLine()!!
    val keys = "asdfghjkl"
    println((0..s.length - 2).map { Math.abs(keys.indexOf(s[it]) - keys.indexOf(s[it + 1])) + 1 }.sum())
}
