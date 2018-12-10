package participated.abc115

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val hList = mutableListOf<Long>()
    for (i in 1..n) {
        hList.add(readLine()!!.toLong())
    }
    hList.sort()
    var sa = Long.MAX_VALUE

    for (i in 0..(n - k)) {
        sa = Math.min(sa, hList[i.toInt() + k.toInt() - 1] - hList[i.toInt()])
    }
    print(sa)
}
