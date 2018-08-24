package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toLong)
    val aAccumulation = mutableListOf(0L)
    val countMap = mutableMapOf<Long,Long>()
    countMap[0]=1L
    var ans = 0L
    for (i in 1..n) {
        val accumlation = aAccumulation[i - 1] + aList[i - 1]
        aAccumulation.add(accumlation)
        if(countMap.containsKey(accumlation)){
            ans += countMap[accumlation]!!
            countMap[accumlation] = countMap[accumlation]!!+1L
        }else{
            countMap[accumlation] = 1L
        }
    }
    println(ans)
}
