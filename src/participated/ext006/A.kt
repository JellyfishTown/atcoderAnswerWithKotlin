package participated.ext006

//https://atcoder.jp/contests/exawizards2019
fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)
    if (a == b && b == c) {
        println("Yes")
    } else {
        println("No")
    }
}
