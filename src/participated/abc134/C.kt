package participated.abc134

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<Long>()
    (1..n).forEach { aList.add(readLine()!!.toLong()) }
    val aList2 = aList.sorted()
    val max = aList2[n-1]
    val max2 = aList2[n-2]
    for(i in 0 until n){
        if(aList[i]==max){
            println(max2)
        }else{
            println(max)
        }
    }
}
