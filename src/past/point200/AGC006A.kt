package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()
    val t = readLine()!!.toCharArray()

    for (i in 0..n) {
        var flg = true
        for (j in 0..n - i) {
            if (i + j >= n) break
            if (s[i + j] != t[j]) flg = false
        }
        if (flg) {
            println(n + i)
            return
        }
    }
}

