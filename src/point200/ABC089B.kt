package point200

fun main(args: Array<String>) {
    val n = readLine()!!
    val s = readLine()!!.split(" ")
    println(if (s.contains("Y")) "Four" else "Three")
}