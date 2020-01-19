package participated.abc148

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    var maxNum = 0L
    for(i in 0 until n){
        if(aList[i]==maxNum+1){
            maxNum++
        }
    }

    if (aList.contains(1).not()) {
        println(-1)
    } else {
        println(n-maxNum)
    }
}