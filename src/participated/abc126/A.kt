package participated.abc126

fun main(args: Array<String>) {
    val (n ,k) = readLine()!!.split(' ').map(String::toInt)
    val s = readLine()!!.toCharArray()
    s[k-1] = s[k-1].toLowerCase()
    println(s.joinToString(""))
}
