package participated.abc162

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val ts = readLine()!!.toMutableList()
    ts.add(0, 'x')
    ts.add('x')
    val s = ts.toCharArray()
    if (n < 4) {
        println(0)
        return
    }
    val jmap = mutableMapOf<Char, LongArray>()
    jmap['R'] = LongArray(4001)
    jmap['G'] = LongArray(4001)
    jmap['B'] = LongArray(4001)

    for (c in "RGB") {
        for (j in 1..n - 1) {
            var tempSum = 0L
            for (k in j + 1..n) {
                if (c != s[j] && c != s[k] && s[j] != s[k]) tempSum++
            }
            jmap[c]!![j] = tempSum
        }
    }

    var ans = 0L

    for (i in 1..n - 2) {
        for (j in i + 1..n - 1) {
            val add = jmap[s[i]]!![j]
            ans += add
            if (add > 0) {
                val diff = j - i
                val k = j + diff
                if (k <= n)
                    if (s[k] != s[i] && s[k] != s[j]) ans--
            }
        }
    }

    println(ans)
}
