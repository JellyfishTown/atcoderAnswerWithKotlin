package abc106

fun main(args: Array<String>) {
    val s = readLine()!!
    val k = readLine()!!.toLong()
    var oneLength = 0
    for (c in s) {
        if (c == '1') {
            oneLength++
        } else {
            break
        }
    }

    if (k == 1L) {
        println(s[0])
    } else if (k <= oneLength) {
        println(1)
    } else {
        println(s[oneLength])
    }
}
