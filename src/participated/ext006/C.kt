package participated.ext006

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map(String::toInt)
    val s = readLine()!!
    val td = Array(q) { readLine()!!.split(' ').map { it[0] } }
    var min = 0
    var max = s.length - 1
    for (i in q - 1 downTo 0) {
        val (t, d) = td[i]
        if (min <= s.length && t == s[min] && d == 'L') min++
        if (max >= 0 && t == s[max] && d == 'R') max--
    }
    if (max < 0 || min > s.length - 1) println(0)
    else println(max - min + 1)
}