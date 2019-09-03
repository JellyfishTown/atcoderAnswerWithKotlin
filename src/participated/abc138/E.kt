package participated.abc138

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    val sMap = mutableMapOf<Char, MutableList<Int>>()
    val tMap = mutableMapOf<Char, MutableList<Int>>()
    ('a'..'z').forEach { sMap[it] = mutableListOf() }
    ('a'..'z').forEach { tMap[it] = mutableListOf() }
    s.forEachIndexed { index, c -> sMap[c]!!.add(index) }
    t.forEachIndexed { index, c -> tMap[c]!!.add(index) }


    ('a'..'z').forEach {
        if (tMap[it]!!.size > 0 && sMap[it]!!.size == 0) {
            println(-1)
            return
        }
    }
    var si = -1
    var ti = 0
    var count = 0L
    val used = mutableMapOf<Char, Int>()
    ('a'..'z').map { used[it] = 0 }
    while (ti != t.length) {
        var ui = used[t[ti]]!!
        var updated = false
        while (true) {
            val tempt = t.getOrNull(ti) ?: break
            val temps = sMap[tempt]
            val tempsi = temps?.getOrNull(ui)
            if (tempsi != null) {
                if (tempsi > si) {
                    used[t[ti]] = used[t[ti]]!! + 1
                    si = tempsi
                    ti++
                    updated = true
                } else {
                    ui++
                }
            } else {
                break
            }
        }

        if (!updated && ti != t.length) {
            count++
            si = -1
            ('a'..'z').map { used[it] = 0 }
        }
    }
    println(count * s.length.toLong() + si.toLong() + 1L)
}


//var si = 0
//var ti = 0
//var count = 0L
//while (ti != t.length) {
//    if (t[ti] == s[si]) {
//        ti++
//        si++
//    } else {
//        si++
//    }
//    if (si == s.length) si = 0
//    count++
//}
//
//println(count)