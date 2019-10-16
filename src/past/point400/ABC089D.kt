package past.point400

fun main(args: Array<String>) {
    fun calcMana(a: Pair<Int, Int>, b: Pair<Int, Int>) =
            (Math.abs(a.first - b.first) + Math.abs(a.second - b.second)).toLong()
    val (h, w, d) = readLine()!!.split(' ').map(String::toInt)
    val pArray = Array((h * w + 1)) { Pair(0, 0) }
    val mArray = Array((h * w + 1)) { 0L }
    for (i in 1..h) {
        val aList = readLine()!!.split(' ').map(String::toLong)
        for (j in 1..w) {
            pArray[aList[j - 1].toInt()] = Pair(i, j)
        }
    }
    for (start in 1..d) {
        var curP = start
        var nextP = curP + d
        while (nextP <= h * w) {
            val mana = calcMana(pArray[curP], pArray[nextP])
            mArray[nextP] = mArray[curP] + mana
            curP = nextP
            nextP += d
        }
    }

    val q = readLine()!!.toInt()
    for (i in 1..q) {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        println(mArray[r]-mArray[l])
    }
}
