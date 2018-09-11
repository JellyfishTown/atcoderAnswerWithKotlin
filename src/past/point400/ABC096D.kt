package past.point400
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = getSosuList(55555).filter { it % 5 == 1 }

    println(list.subList(0,n).joinToString(" "))
}

fun getSosuList(max: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    (2..max).filter { i ->
                (2..Math.sqrt(i.toDouble()).toInt()).all { j -> i % j != 0 }
            }
            .forEach { n -> list.add(n) }
    return list
}
