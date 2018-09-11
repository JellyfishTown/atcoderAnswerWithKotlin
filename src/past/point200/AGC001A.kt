package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val l = readLine()!!.split(" ").map(String::toLong)
    println(l.sorted().filterIndexed { index, l -> index % 2 == 0 }.sum())
}

