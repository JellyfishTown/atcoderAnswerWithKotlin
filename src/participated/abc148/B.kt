package participated.abc148

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val (s, t) = readLine()!!.split(' ')
    val ans = mutableListOf<Char>()

    (0 until n).forEach {
        ans.add(s[it])
        ans.add(t[it])
    }
    println(ans.joinToString(""))
}