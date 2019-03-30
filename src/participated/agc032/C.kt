package participated.agc032

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    val pList = readLine()!!.split(' ').map(String::toLong).toMutableList()

    var total = 0L
    for (i in (n.toInt() - 1) downTo 1) {
        var max = 0L
        var maxi = 0
        for (j in 0..i) {
            if (pList[j] > max) {
                max = pList[j]
                maxi = j
            }
        }
        if(maxi == i )continue
        val lCost = a * (maxi + 1)
        val rCost = b * (i - maxi)

        if (rCost > lCost) {
            for (k in 1..(maxi + 1)) {
                pList.add(pList.removeAt(0))
                total += a
            }
        } else {
            for (k in 1..(i - maxi)) {
                pList.add(0, pList.removeAt(i))
                total += b
            }
        }
    }
    println(total)
}
