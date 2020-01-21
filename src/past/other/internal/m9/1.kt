package past.other.internal.m9

fun main(args: Array<String>) {
    val s: String = readLine()!!
    val memberNum = s.count { it == 'B' }
    val aNum = s.count { it == 'A' }
    val cNum = s.count { it == 'C' }
    if (memberNum != cNum || aNum < memberNum * 2 || memberNum == 0 || aNum == 0 || s.first() != 'A' || s.last() != 'A') {
        println("NO")
        return
    }
    val lastB = s.indexOfLast { it == 'B' }
    val lastC = s.indexOfFirst { it == 'C' }
    val aNumUntilLastB = s.substring(0, lastB).count { it == 'A' }
    val aNumAfterFirstC = s.substring(lastC - 1).count { it == 'A' }
    if (aNumUntilLastB < memberNum || aNumAfterFirstC < memberNum) {
        println("NO")
        return
    }


    var ac = 0`
    var bc = 0
    var cc = 0
    for (i in 0 until s.length) {
        val c = s[i]
        when (c) {
            'A' -> ac++
            'B' -> bc++
            'C' -> cc++
        }
        if (cc > bc || bc > ac || cc > ac) {
            println("NO")
            return
        }
        if (bc == memberNum && cc == 0 && s[i + 1] != 'C') {
            println("NO")
            return
        }
    }
    ac = 0
    bc = 0
    cc = 0
    for (i in s.length - 1 downTo 0) {
        val c = s[i]
        when (c) {
            'A' -> ac++
            'B' -> bc++
            'C' -> cc++
        }
        if (cc < bc || bc > ac || cc > ac) {
            println("NO")
            return
        }
        if (cc == memberNum && bc == 0 && s[i - 1] != 'B') {
            println("NO")
            return
        }
    }
    println("YES")
}