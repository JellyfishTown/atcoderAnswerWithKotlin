package past.point400

// なし
fun main(args: Array<String>) {
    val (n, h) = readLine()!!.split(' ').map(String::toLong)
    var aMax = 0L
    val bList = mutableListOf<Long>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        aMax = Math.max(aMax, a)
        bList.add(b)
    }
    val fbList = bList.filter { it > aMax }.sortedDescending()

    var totalD = 0L
    for (i in fbList.indices) {
        totalD += fbList[i]
        if (totalD >= h) {
            println(i + 1)
            return
        }
    }
    val addAttack = Math.ceil((h - totalD).toDouble() / aMax.toDouble()).toLong()
    println(fbList.size + addAttack)
}
