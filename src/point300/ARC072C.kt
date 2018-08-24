package point300


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    println(Math.min(calcCount(aList,true),calcCount(aList,false)))
}

fun calcCount(aList: List<Long>, f:Boolean): Long {
    var flag = f
    var sum = 0L
    var count = 0L

    for (i in 0 until aList.size) {
        sum += aList[i]
        when {
            sum == 0L -> {
                count++
                sum = if (flag) 1 else -1
            }
            flag == sum > 0 -> {
                //do nothing
            }
            flag == sum < 0 -> {
                count += Math.abs(sum) + 1
                sum = if (flag) 1 else -1
            }
        }
        flag = !flag
    }
    return count
}
