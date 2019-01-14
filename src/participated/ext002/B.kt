package participated.ext002

//https://aising2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    val pList = readLine()!!.split(' ').map(String::toLong)
    val one = pList.filter { it <= a }
    val two = pList.filter { a + 1 <= it && it <= b }
    val three = pList.filter { b + 1 <= it }
    println(Math.min(one.size, Math.min(two.size, three.size)))
}
