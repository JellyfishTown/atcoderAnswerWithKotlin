fun main(args: Array<String>) {
    val s = readLine()!!
    val n1 = s.mapIndexed { index, c ->
        if (index % 2 == 0 && c == '1') 1
        else if (index % 2 == 1 && c == '0') 1
        else 0
    }.sum()
    val n2 = s.mapIndexed { index, c ->
        if (index % 2 == 1 && c == '1') 1
        else if (index % 2 == 0 && c == '0') 1
        else 0
    }.sum()
    println(Math.min(n1, n2))
}
