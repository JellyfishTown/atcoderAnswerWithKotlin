package past.point200

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map(String::toInt)
    val k = readLine()!!.toInt()
    val max = Math.max(a, Math.max(b, c))
    val result = max * Math.pow(2.toDouble(), k.toDouble()).toInt() - max + a + b + c
    println(result)
}