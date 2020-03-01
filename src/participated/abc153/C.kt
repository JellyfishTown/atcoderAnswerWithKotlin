package participated.abc153

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val hList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    if(n<=k){
        println(0)
        return
    }
    val sum = hList.takeLast(n - k).sum()
    println(sum)
}