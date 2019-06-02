package participated.ext009

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val count = s.count { it == 'x' }
    if (count >= 8) {
        println("NO")

    } else {
        println("YES")
    }
}
