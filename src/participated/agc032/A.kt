package participated.agc032

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var bList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    for (i in 0 until n) {
        if (bList[i] > i + 1) {
            println(-1)
            return
        }
    }
    val ans = mutableListOf<Int>()
    while (true) {
        val temp = mutableListOf<Int>()
        var max = 0
        var maxi = -1
        bList.forEachIndexed { index, b ->
            if (index + 1 == b) {
                if (max < b) {
                    max = b
                    maxi = index
                }
            }
        }
        ans.add(max)
        bList.forEachIndexed { index, b ->
            if (index != maxi) {
                temp.add(b)
            }
        }
        bList = temp
        if (bList.size == 0) break
    }
    ans.reversed().forEach { println(it) }
}
