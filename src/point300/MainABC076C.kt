package point300

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    for (i in 0..(s.length - t.length)) {
        var includeFlg = true
        for (j in 0 until t.length) {
            if (s[s.length - 1 - i - j] != '?' && (s[s.length - 1 - i - j] != t[t.length - 1 - j])) {
                includeFlg = false
                break
            }
        }
        if (includeFlg) {
            val s2 = s.replaceRange(s.length - t.length - i, s.length - i, t)
            val s3 = s2.replace("?", "a")
            println(s3)
            return
        }
    }
    println("UNRESTORABLE")
}
