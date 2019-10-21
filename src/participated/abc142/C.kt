package participated.abc142

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val ansArray = Array(n+1){0}
    for(i in 0 until n){
        ansArray[aList[i]] = i+1
    }
    for(i in 1..n){
        print("${ansArray[i]} ")
    }
    println()
}