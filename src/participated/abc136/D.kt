package participated.abc136

fun main(args: Array<String>) {
    val s = readLine()!!
    val len = s.length
    val ans = IntArray(len) { 0 }

    var rc = 0
    var lc = 0
    var ls = -1
    for (i in 0 until len - 1) {
        if (s[i] == 'R') rc++
        if (s[i] == 'L') lc++
        if (s[i] == 'R' && s[i + 1] == 'L') {
            ans[i] = rc / 2 + (rc % 2)
            ans[i + 1] = rc / 2
            rc = 0
            ls = i + 1
        }
        if (s[i] == 'L' && s[i + 1] == 'R') {
            ans[ls-1] += lc/2
            ans[ls] += lc / 2 + (lc % 2)
            lc = 0
        }
    }
    lc++
    ans[ls-1] += lc/2
    ans[ls] += lc / 2 + (lc % 2)


    println(ans.joinToString(" "))
}
