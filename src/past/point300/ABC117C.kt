fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val x = readLine()!!.split(" ").map(String::toInt).sorted()
    val d = mutableListOf<Int>()
    (1 until m).forEach { d.add(x[it] - x[it - 1]) }
    d.sort()
    println(d.filterIndexed { index, i -> index < m - n }.sum())
}

