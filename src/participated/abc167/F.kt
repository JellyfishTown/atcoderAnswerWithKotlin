package participated.abc167

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = (1..n).map { readLine()!! }
    val countLR = mutableListOf<Triple<Int, Int, Int>>()//index left right

    fun countLR(s: String): Pair<Int, Int> {
        var tl = 0
        var tr = 0
        for (c in s) {
            if (c == '(') {
                tr++
            } else {
                if (tr > 0) tr--
                else tl++
            }
        }
        return Pair(tl, tr)
    }
    for (i in 0 until n) {
        val (l, r) = countLR(sList[i])
        countLR.add(Triple(i, l, r))
    }
    countLR.sortByDescending { it.third }
    countLR.sortBy { it.second }
    val temp = mutableListOf<String>()
    for (i in 0 until n) {
        val (index, l, r) = countLR[i]
        if (l == 0 && r != 0) temp.add(sList[index])
    }
    for (i in 0 until n) {
        val (index, l, r) = countLR[i]
        if (l != 0 && r != 0) temp.add(sList[index])
    }
    for (i in 0 until n) {
        val (index, l, r) = countLR[i]
        if (l != 0 && r == 0) temp.add(sList[index])
    }
    val anss = temp.joinToString("")
//    println(anss)
    val (l, r) = countLR(anss)
    if (l == 0 && r == 0) {
        println("Yes")
    } else {
        println("No")
    }
}
