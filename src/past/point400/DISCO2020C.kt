package past.point400

fun main(args: Array<String>) {
    val (h, w, k) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(h) { CharArray(w) { '.' } }
    (0 until h).forEach { map[it] = readLine()!!.toCharArray() }
    val ansMap = Array(h) { IntArray(w) { 0 } }
    val sList = mutableListOf<Pair<Int, Int>>()
    for (th in 0 until h) {
        for (tw in 0 until w) {
            if (map[th][tw] == '#') sList.add(Pair(th, tw))
        }
    }
    var ansNum = 1
    for (s in sList) {
        val (sh, sw) = s
        ansMap[sh][sw] = ansNum
        var tw = sw
        while (true) {
            tw--
            if (tw < 0 || map[sh][tw] == '#') break
            ansMap[sh][tw] = ansNum
        }
        tw = sw
        while (true) {
            tw++
            if (tw >= w || map[sh][tw] == '#' ||ansMap[sh][tw]!=0) break
            ansMap[sh][tw] = ansNum
        }
        ansNum++
    }

    for (th in 1 until h) {
        for (tw in 0 until w) {
            if (ansMap[th][tw] == 0) ansMap[th][tw] = ansMap[th - 1][tw]
        }
    }

    for (th in (h-2) downTo 0) {
        for (tw in 0 until w) {
            if (ansMap[th][tw] == 0) ansMap[th][tw] = ansMap[th + 1][tw]
        }
    }
    ansMap.forEach {
        println(it.joinToString(" "))
    }
}
