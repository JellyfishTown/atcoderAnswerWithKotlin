package participated.abc115

val bList = mutableListOf<Long>()
val pList = mutableListOf<Long>()

fun main(args: Array<String>) {
    val (nTemp, x) = readLine()!!.split(' ').map(String::toLong)
    val n = nTemp.toInt()
    bList.add(0L)
    pList.add(1L)
    for (i in 1..n) {
        bList.add(bList[i - 1] * 2 + 2)
        pList.add(pList[i - 1] * 2 + 1)
    }
    print(calc(n, x))
}

fun calc(n: Int, x: Long): Long {
    val length = bList[n] + pList[n]
    if (x == 0L) return 0L
    if (n == 0) return x
    if (length / 2 + 1 == x) {
        return pList[n] / 2 + 1
    } else if (length / 2 + 1 < x) {
        return pList[n] / 2 + 1 + calc(n - 1, x - (length / 2 + 1) - if (length == x) 1 else 0)
    } else {
        return calc(n - 1, x - 1)
    }
}
