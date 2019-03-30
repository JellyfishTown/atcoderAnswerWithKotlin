package participated.agc032

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n)
        for (j in (i + 1)..n)
            list.add(Pair(i, j))
    for (i in 1..(n / 2)) list.remove(Pair(i, n - i + (n + 1) % 2))
    println(list.size)
    list.forEach { println("${it.first} ${it.second}") }
}
