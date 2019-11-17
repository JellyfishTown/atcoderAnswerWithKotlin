package participated.abc145

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    if (s.substring(0,n/2)==s.substring(n/2)) {
        println("Yes")
    } else {
        println("No")
    }
}