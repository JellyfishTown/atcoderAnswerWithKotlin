package participated.abc158

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val q = readLine()!!.toInt()
    val frontAdd = CharArray(q) { '.' }
    var frontI = q - 1
    val backAdd = CharArray(q) { '.' }
    var backI = 0
    var mode = true
    for (i in 1..q) {
        val inList = readLine()!!.split(' ')
        if (inList[0] == "1") {
            mode = !mode
        } else {
            val (t, f, c) = inList
            if ((mode && f == "1") || (!mode && f == "2")) {
                frontAdd[frontI--] = c[0]
            } else {
                backAdd[backI++] = c[0]
            }
        }
    }
    val ans = frontAdd.filter { it != '.' }.toCharArray() + s + backAdd.filter { it != '.' }
    if (!mode) ans.reverse()
    println(ans.joinToString(""))
}
