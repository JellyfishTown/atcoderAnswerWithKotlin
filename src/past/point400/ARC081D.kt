package past.point400

fun main(args: Array<String>) {
    val mod = 1000000007L
    val n = readLine()!!.toInt()
    val s = readLine()!!
    readLine()!!
    var i = if (s[0] == s.getOrNull(1)) 2 else 1
    var ans = if (s[0] == s.getOrNull(1)) 6L else 3L
    var before = if (s[0] == s.getOrNull(1)) "yoko" else "tate"

    while (i < s.length) {
        val cur = if (s[i] == s.getOrNull(i+1)) "yoko" else "tate"
        if (s[i] == s.getOrNull(i+1)) i += 2 else i++
        when {
            (before == "tate" && cur == "tate") -> {ans*=2}
            (before == "tate" && cur == "yoko") -> {ans*=2}
            (before == "yoko" && cur == "tate") -> {ans*=1}
            (before == "yoko" && cur == "yoko") -> {ans*=3}
        }
        ans%=mod
        before = cur
    }
    println(ans)
}
