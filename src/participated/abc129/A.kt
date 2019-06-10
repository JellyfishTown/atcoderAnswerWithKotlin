package participated.abc129
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').map(String::toLong).sorted()
    println(input[0]+input[1])
}
