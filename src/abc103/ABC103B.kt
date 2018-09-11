package abc103


fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    for (i in 0 until t.length) {
        var isSame = true
        for (j in 0 until t.length) {
            val si = if ((j + i) >= t.length) {
                j + i - t.length
            } else {
                j + i
            }
            if (t[j] != s[si]) isSame = false
        }
        if (isSame) {
            println("Yes")
            return
        }
    }
    println("No")
}

