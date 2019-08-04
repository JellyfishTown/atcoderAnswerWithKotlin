package participated.abc136

fun main(args: Array<String>) {
    println((1..(readLine()!!.toInt())).filter { it.toString().length % 2!=0 }.count())
}
