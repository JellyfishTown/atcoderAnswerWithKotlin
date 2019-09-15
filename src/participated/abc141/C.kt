package participated.abc141

fun main(args: Array<String>) {
    val (n, k, q) = readLine()!!.split(' ').map(String::toLong)
    val aList = mutableListOf<Long>()
    val ansCount = Array(n.toInt() + 1) { 0 }
    (1..q).forEach {
        val a = readLine()!!.toLong()
        aList.add(a)
        ansCount[a.toInt()] = ansCount[a.toInt()] + 1
    }

    for (i in 1..n.toInt()) {
        val p = k - q + ansCount[i]
        if (p > 0) {
            println("Yes")
        } else {
            println("No")
        }
    }
}