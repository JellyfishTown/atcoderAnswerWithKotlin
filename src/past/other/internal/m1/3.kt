package past.other.internal.m1

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

//fun main(args: Array<String>) {
//    println((1..(readLine()!!.toInt())).map { if (it.toString().reversed().toInt() > it) 1 else 0 }.sum())
//}
