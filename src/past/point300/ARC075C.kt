package past.point300


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = mutableListOf<Int>()

    for(i in 1..n){
        sList.add(readLine()!!.toInt())
    }
    sList.sort()
    val sum = sList.sum()
    if(sum % 10 != 0){
        println(sum)
        return
    }
    for(i in 0 until n){
        val result = sum - sList[i]
        if(result % 10 != 0){
            println(result)
            return
        }
    }
    println(0)
}
