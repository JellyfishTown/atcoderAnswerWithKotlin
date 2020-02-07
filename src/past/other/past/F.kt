package past.other.past

fun main(args: Array<String>) {
    val s = readLine()!!
    val inList = mutableListOf<String>()
    var left = 0
    var right = 1
    while (left < s.length - 1) {
        if (s[right].isUpperCase()) {
            inList.add(s.substring(left, right + 1))
            left = right + 1
            right = left + 1
        } else {
            right++
        }
    }
    println(inList.sortedBy { it.toLowerCase() }.joinToString(""))
}
