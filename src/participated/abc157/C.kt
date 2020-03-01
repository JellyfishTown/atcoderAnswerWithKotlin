package participated.abc157

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val ans = IntArray(n) { -1 }

    for (i in 1..m) {
        val (s, c) = readLine()!!.split(' ').map(String::toInt)
        if ((n > 1 && s == 1 && c == 0) || (ans[s - 1] != -1 && ans[s - 1] != c)) {
            println(-1)
            return
        }
        ans[s - 1] = c
    }
    if (ans[0] == -1 && n > 1) ans[0] = 1
    if (ans[0] == -1 && n == 1) ans[0] = 0
    for (i in 1 until n)
        if (ans[i] == -1) ans[i] = 0
    println(ans.joinToString(""))
}
