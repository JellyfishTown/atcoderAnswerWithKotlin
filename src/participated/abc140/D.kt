package participated.abc140

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val s = readLine()!!
    var ans = 0L
    for (i in 0 until n.toInt()) {
        if (s[i] == 'L' && i > 0) {
            if (s[i - 1] == 'L') ans++
        } else if (s[i] == 'R' && i < n - 1) {
            if (s[i + 1] == 'R') ans++
        }
    }
    println(Math.min(ans + 2 * k, n - 1))
}