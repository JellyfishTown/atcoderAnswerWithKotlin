package participated.abc167

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!

    if (t.substring(0, t.length-1) == s) {
        println("Yes")
    } else {
        println("No")
    }
}
