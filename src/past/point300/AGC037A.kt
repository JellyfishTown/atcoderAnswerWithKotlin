fun main(args: Array<String>) {
    val s = readLine()!!
    var ans = 1
    var i = 1
    var before = s[0].toString()
    while (i < s.length) {
        ans++
        if (before == s[i].toString()) {
            if (s.length == i + 1) {
                ans--
                break
            }
            before = s.substring(i, i + 2)
            i += 2
        } else {
            before = s[i].toString()
            i++
        }
    }
    println(ans)
}
