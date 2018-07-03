package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = mutableListOf<Int>()
    for(i in 1..n)an.add(readLine()!!.toInt())
    println(an.sortedDescending().distinct().size)
}

