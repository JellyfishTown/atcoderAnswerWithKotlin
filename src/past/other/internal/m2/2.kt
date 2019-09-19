package past.other.internal.m2

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).sorted()
    val bList = readLine()!!.split(' ').map(String::toLong).sorted()
    val ans = (0 until n).map{Math.abs(aList[it] - bList[it])}.sum()
    println(ans)
}
