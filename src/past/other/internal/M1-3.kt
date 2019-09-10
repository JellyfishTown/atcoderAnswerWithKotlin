package past.other.internal

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var ans = 0
    (1..n).forEach {
        val its = it.toString()
        val rev = its.reversed().toInt()
        if (rev > it) ans++
    }
    println(ans)
}
