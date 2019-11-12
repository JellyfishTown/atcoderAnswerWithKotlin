package past.other.internal.m7

fun main(args: Array<String>) {
    fun calcScore(s: String): Int {
        val count = (0 until s.length - 1).count { s[it] == '1' && s[it + 1] == '1' }
        return count * count
    }

    val s = readLine()!!
    val k = readLine()!!.toInt()

    var ans = 0L

    //0
    ans += calcScore(s)

    //1
    for (i in 0 until s.length) {
        val changedS = s.toCharArray()
        changedS[i] = if (s[i] == '0') '1' else '0'
        ans += calcScore(changedS.joinToString(""))
    }

    //2
    if (k >= 2) {
        for (i in 0 until s.length - 1) {
            for (j in i + 1 until s.length) {
                val changedS = s.toCharArray()
                changedS[i] = if (s[i] == '0') '1' else '0'
                changedS[j] = if (s[j] == '0') '1' else '0'
                ans += calcScore(changedS.joinToString(""))
            }
        }
    }

    //3
    if (k >= 3) {
        for (i in 0 until s.length - 2) {
            for (j in i + 1 until s.length - 1) {
                for (k in j + 1 until s.length) {
                    val changedS = s.toCharArray()
                    changedS[i] = if (s[i] == '0') '1' else '0'
                    changedS[j] = if (s[j] == '0') '1' else '0'
                    changedS[k] = if (s[k] == '0') '1' else '0'
                    ans += calcScore(changedS.joinToString(""))
                }
            }
        }
    }

    println(ans)
}

