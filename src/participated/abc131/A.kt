package participated.abc131

fun main(args: Array<String>) {
    val s = readLine()!!
    if (s[0] == s[1] || s[1] == s[2] || s[2] == s[3]) {
        println("Bad")
    } else {
        println("Good")
    }
}
