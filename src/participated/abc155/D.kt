package participated.abc155

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    val minusNum = aList.count { it < 0 }
    val plusNum = aList.count { it > 0 }
    val zeroNum = aList.count { it == 0L }

    val minusAnsNum = minusNum * plusNum
    val zeroAnsNum = zeroNum * (minusNum + plusNum) + (zeroNum * (zeroNum - 1) / 2)
    val plusAnsNum = n * (n - 1) / 2 - minusAnsNum - zeroAnsNum
    if (k <= minusAnsNum) {
        val pluslist = aList.filter { it > 0L }.map { Math.abs(it) }.sortedDescending()
        val minuslist = aList.filter { it < 0L }.map { Math.abs(it) }.sortedDescending()
        val ansList = mutableListOf<Long>()
        for (p in pluslist) {
            for (m in minuslist) {
                ansList.add(p * m)
            }
        }
        ansList.sortDescending()
        println(-ansList[k.toInt()])
    } else if (k <= minusAnsNum + zeroAnsNum) {
        println(0)
    } else {
        val pluslist = aList.filter { it > 0L }.map { Math.abs(it) }.sorted()
        val minuslist = aList.filter { it < 0L }.map { Math.abs(it) }.sorted()
        val ansList = mutableListOf<Long>()
        for (i in 0 until pluslist.size) {
            for (j in i + 1 until pluslist.size) {
                if (i == j) continue
                ansList.add(pluslist[i] * pluslist[j])
            }
        }
        for (i in 0 until minuslist.size) {
            for (j in i + 1 until minuslist.size) {
                if (i == j) continue
                ansList.add(minuslist[i] * minuslist[j])
            }
        }
        ansList.sort()
        ansList.forEach { println(it) }
//        println(ansList[k.toInt() - minusAnsNum - zeroAnsNum - 1])
    }
}
