//https://atcoder.jp/contests/nikkei2019-final/tasks/nikkei2019_final_c
fun main(args: Array<String>) {
    val (h, w, k) = readLine()!!.split(" ").map(String::toLong)
    val hValues = LongArray(h.toInt()) { w }
    val wValues = LongArray(w.toInt()) { h }
    for (i in 1..k) {
        val (r, c) = readLine()!!.split(" ").map(String::toInt)
        hValues[r - 1] = hValues[r - 1] - 1
        wValues[c - 1] = wValues[c - 1] - 1
    }
    val medH = (hValues.sum() + 1) / 2
    val medW = (wValues.sum() + 1) / 2

    var temp = 0L
    var goalH = 0
    for (i in 0 until hValues.size) {
        temp += hValues[i]
        if (temp >= medH) {
            goalH = i
            break
        }
    }
    temp = 0L
    var goalW = 0
    for (i in 0 until wValues.size) {
        temp += wValues[i]
        if (temp >= medW) {
            goalW = i
            break
        }
    }

    var totalCost = 0L
    for (i in 0 until hValues.size)
        totalCost += Math.abs(goalH - i) * hValues[i]
    for (i in 0 until wValues.size)
        totalCost += Math.abs(goalW - i) * wValues[i]

    println(totalCost)
}
