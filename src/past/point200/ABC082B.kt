package past.point200

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val t = readLine()!!.toCharArray()
    val s1 = s.sorted().joinToString()
    val t1 = t.sortedDescending().joinToString()
    if (s1 < t1) {
        println("Yes")
    } else {
        println("No")
    }
}

