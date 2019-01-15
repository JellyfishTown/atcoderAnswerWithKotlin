package participated.ext003


fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aSet = readLine()!!.split(' ').map(String::toLong).toSortedSet()
    val bSet = readLine()!!.split(' ').map(String::toLong).toSortedSet()

    if (n.toInt() != aSet.size || m.toInt() != bSet.size) {
        println(0)
        return
    }

    var answer = 1L
    for (i in n * m downTo 1) {
        val aContains = aSet.contains(i)
        val bContains = bSet.contains(i)
        if (aContains && bContains) {
            //do nothing
        } else if (aContains) {
            val first = bSet.indexOfFirst { it >= i }
            answer *= if (first == -1) 0 else (m - first)
        } else if (bContains) {
            val first = aSet.indexOfFirst { it >= i }
            answer *= if (first == -1) 0 else (n - first)
        } else {
            val aFirst = aSet.indexOfFirst { it >= i }
            val bFirst = bSet.indexOfFirst { it >= i }
            answer *=
                    if (aFirst == -1 || bFirst == -1) 0
                    else (n - aFirst) * (m - bSet.indexOfFirst { it >= i }) - (n * m - i)
        }
        answer %= 1000000007
    }
    println(answer)
}
