package abc103

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val abList = mutableListOf<Pair<Int,Int>>()
    for (i in 0 until m) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        abList.add(Pair(a,b))
    }
    abList.sortBy { it.first }

    val groupNumList = Array(n + 2, { 1 })
    for (i in 0 until m) {
        val (a, b) = abList[i]
        if (groupNumList[a] == groupNumList[b]) {
            for (i in b..n) {
                groupNumList[i] = groupNumList[i] + 1
                if (groupNumList[i] == groupNumList[i + 1]) break
            }
        }
    }
    println(groupNumList[n] - 1)
}

