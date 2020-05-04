package participated.abc165

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val numList = (1..n.toLong()).map { it }

    val pList = (0 until n).map { aList[it] + numList[it] }
    val mList = (0 until n).map { -aList[it] + numList[it] }

    val pArray = LongArray(n + 1) { 0 }
    val mArray = LongArray(n + 1) { 0 }

    pList.forEach {
        try {
            pArray[it.toInt()]++
        } catch (e: IndexOutOfBoundsException) {
            //do nothing
        }
    }
    mList.forEach {
        try {
            mArray[it.toInt()]++
        } catch (e: IndexOutOfBoundsException) {
            //do nothing
        }
    }
    var ans = 0L
    for (i in 2..n) {
        ans += pArray[i] * mArray[i]
    }
    println(ans)
}
