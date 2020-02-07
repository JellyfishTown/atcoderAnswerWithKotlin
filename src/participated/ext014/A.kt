package participated.ext014

fun main(args: Array<String>) {
    val h = readLine()!!.toInt()
    val w = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val max = Math.max(w,h)
    println(Math.ceil(n.toDouble()/max.toDouble()).toLong())
}