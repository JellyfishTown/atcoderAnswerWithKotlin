package abc106

fun main(args: Array<String>) {
    val (a,b) = readLine()!!.split(' ').map(String::toInt)
    val answer = a * b - a - b + 1
    println(answer)
}
