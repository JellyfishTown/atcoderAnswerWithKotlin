package past.other.google.kick2020


fun main(args: Array<String>) {
    fun divWithCeil(a: Long, b: Long): Long {
        return (a + b - 1) / b
    }

    val t = readLine()!!.toInt()
    for (i in 1..t) {
        val (n, k) = readLine()!!.split(' ').map(String::toInt)
        val mList = readLine()!!.split(' ').map(String::toLong)
        val diffList = (1 until n).map { mList[it] - mList[it - 1] }
        var right = mList.last() - mList.first()
        var left = 0L
        while (right - left != 1L) {
            val targetCost = (right + left) / 2
            var sumCost = 0L
            for (diff in diffList) {
                val cost = divWithCeil(diff, targetCost) - 1
                sumCost+=cost
            }
            if(sumCost>k){
                left = targetCost
            }else{
                right = targetCost
            }
        }
        println("Case #$i: $right")
    }
}
