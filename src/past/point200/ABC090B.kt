package past.point200

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)
    var count = 0
    for (i in a..b) {
        val chars = i.toString().toCharArray()
        if (chars[0] == chars[4] && chars[1] == chars[3]) count++
    }
    println(count)
}