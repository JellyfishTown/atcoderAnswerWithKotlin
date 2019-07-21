package participated.abc131

fun main(args: Array<String>) {
    val (n, l) = readLine()!!.split(' ').map(String::toLong)
    val aji = (1..n).map { l + it - 1 }
    val ajiSum = aji.sum()

    var sa = Long.MAX_VALUE
    var aji2 = ajiSum
    for (i in 0 until n) {
        val ajiSum2 = aji.filterIndexed { index, l -> index.toLong() != i }.sum()
        val tsa = Math.abs(ajiSum - ajiSum2)
        if (tsa < sa) {
            sa = tsa
            aji2 = ajiSum2
        }
    }
    println(aji2)
}
