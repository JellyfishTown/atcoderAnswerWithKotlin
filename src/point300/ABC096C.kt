package point300

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val s = Array(h, { Array(w, { "." }) })
    for (i in 0..(h - 1)) {
        s[i] = readLine()!!.split("").filter { it.isNotEmpty() }.map(String::toString).toTypedArray()
    }

    var result = true
    for (i in 0..(h - 1)) {
        for (j in 0..(w - 1)) {
            if (checkBlack(s, i, j).not()) result = false
        }
    }

    println(if (result) "Yes" else "No")
}

fun checkBlack(s: Array<Array<String>>, i: Int, j: Int): Boolean {
    if (s[i][j] == ".") return true

    var (ue, migi, sita, hidari) = arrayOf(false, false, false, false)
    if (i != 0 && s[i - 1][j] == "#") ue = true
    if (j != 0 && s[i][j - 1] == "#") hidari = true
    if (i != (s.size - 1) && s[i + 1][j] == "#") sita = true
    if (j != (s[0].size - 1) && s[i][j + 1] == "#") migi = true

    return ue || hidari || sita || migi
}
