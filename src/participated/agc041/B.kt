package participated.agc041

fun main(args: Array<String>) {
    val (n, m, v, p) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val aListSum = mutableListOf(aList[0])
    (1 until n.toInt()).forEach { aListSum.add(aListSum.last() + aList[it]) }
    val lastP = aList[p.toInt() - 1]
    var ans = p
    while (true) {
        if (aList[ans.toInt()] != lastP || ans == n - 1) break
        ans++
    }
    for (i in ans.toInt() until n.toInt()) {
        val right = n - i
        val cur = aList[i]
        var totalValue = m * v
        totalValue -= (p - 1) * m
        totalValue -= right * m
        val curAdded = (cur + m).toDouble()
        val betweenTotal = aListSum.getOrElse(i - 1){0} - aListSum.getOrElse(p.toInt() - 2) { 0 }
        val temp = (betweenTotal + totalValue).toDouble() / (n - right - (p - 1)).toDouble()

        if (curAdded >= lastP && curAdded >= temp) {
            ans++
        } else {
            break
        }
    }
    println(ans)
}