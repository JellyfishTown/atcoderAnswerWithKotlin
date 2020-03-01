package participated.abc157

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val map = mutableMapOf<Char, IntArray>()
    val tempCount = mutableMapOf<Char, Int>()
    for (c in 'a'..'z') {
        map[c] = IntArray(n) { 0 }
        tempCount[c] = 0
    }

    for (i in 0 until n) {
        tempCount[s[i]] = tempCount[s[i]]!! + 1
        for (c in 'a'..'z') {
            map[c]!![i] = tempCount[c]!!
        }
    }

    val q = readLine()!!.toInt()
    val qList = mutableListOf<Pair<Int, Char>>()
    val countMap = mutableMapOf<Char, Int>()
    for (c in 'a'..'z') {
        countMap[c] = 0
    }
    val tempS = s.toCharArray()
    var beforeL = -1
    var beforeR = -1
    for (x in 1..q) {
        val (type, t1, t2) = readLine()!!.split(' ')
        if (type == "1") {
            val i = t1.toInt() - 1
            val nexC = t2[0]
            val curC = tempS[i]
            countMap[curC] = countMap[curC]!! - 1
            countMap[nexC] = countMap[nexC]!! + 1
            tempS[i] = nexC
        } else {
            val l = t1.toInt() - 1
            val r = t2.toInt() - 1
            if(beforeR!=-1){
                for (c in 'a'..'z') {
                    countMap[c] = countMap[c]!! - map[c]!![beforeR] + if (beforeL == 0) 0 else map[c]!![beforeL - 1]
                }
            }

            for (c in 'a'..'z') {
                countMap[c] = (countMap[c]?:0) + map[c]!![r] - if (l == 0) 0 else map[c]!![l - 1]
            }
            val count = countMap.count { it.value > 0 }
            println(count)
            beforeL = l
            beforeR = r
        }
    }
}
