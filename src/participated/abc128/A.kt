package participated.abc128
fun main(args: Array<String>) {
    val (a, p) = readLine()!!.split(' ').map(String::toLong)
    println((a*3+p)/2)
}
