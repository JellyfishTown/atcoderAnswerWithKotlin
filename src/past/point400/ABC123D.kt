package past.point400


fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)
    val a = readLine()!!.toCharArray()
    val changePoints = mutableListOf(0)
    (1 until n).forEach { if (a[it - 1] != a[it]) changePoints.add(it) }
    changePoints.add(n)
    var max = 0
    var lp = 0
    while (true) {
        val rp = lp + 2 * k - if (a[changePoints[lp]] == '0') 1 else 0
        if (rp >= changePoints.size - 1) {
            max = Math.max(changePoints.last() - changePoints[lp], max)
            break
        }
        max = Math.max(changePoints[rp + 1] - changePoints[lp], max)
        lp++
    }
    println(max)
}
