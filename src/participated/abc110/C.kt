package participated.abc110

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    val sameMapS = mutableMapOf<Char, MutableList<Int>>()
    val sameMapT = mutableMapOf<Char, MutableList<Int>>()
    for (i in 0 until s.length) {
        if (sameMapS[s[i]] == null) sameMapS[s[i]] = mutableListOf(i) else sameMapS[s[i]]!!.add(i)
        if (sameMapT[t[i]] == null) sameMapT[t[i]] = mutableListOf(i) else sameMapT[t[i]]!!.add(i)
    }
    for (key in sameMapT.keys) {
        if (sameMapT[key]!!.size <= 1) continue
        var c = ""
        for (i in sameMapT[key]!!) {
            if (c != "" && s[i].toString() != c) {
                println("No")
                return
            }
            c = s[i].toString()
        }
    }
    for (key in sameMapS.keys) {
        if (sameMapS[key]!!.size <= 1) continue
        var c = ""
        for (i in sameMapS[key]!!) {
            if (c != "" && t[i].toString() != c) {
                println("No")
                return
            }
            c = t[i].toString()
        }
    }
    println("Yes")
}
