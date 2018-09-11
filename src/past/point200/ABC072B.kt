package past.point200

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val ans = StringBuilder()
    s.forEachIndexed { index, c -> if (index % 2 == 0) ans.append(c) }
    println(ans.toString())
}