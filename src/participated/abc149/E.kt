package participated.abc149

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val usedNum = Math.ceil(Math.sqrt(m.toDouble())).toLong()
    val hands = usedNum * 2

    var ans = 0L
    var left = m * 2
    for (i in 0 until usedNum.toInt()) {
        if (left < hands) {
            ans += aList[i] * left
            break
        } else {
            ans += aList[i] * hands
        }
        left -= hands
    }
    println(ans)
}