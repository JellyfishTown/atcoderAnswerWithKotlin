package participated.abc134

fun main(args: Array<String>) {
    val (n, d) = readLine()!!.split(' ').map(String::toDouble)
    println(Math.ceil(n/(d*2+1)).toLong() )
}
