package past.other.google.kick2020


fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 1..t) {
        val (n, k) = readLine()!!.split(' ').map(String::toInt)
        var sList = (1..n).map { readLine()!! }
        var score = 0L

        for (num in 5 downTo 1) {
            val overNumSList = sList.filter { it.length >= num }
            val prefixCount = overNumSList.groupBy { it.take(num)}.toMutableMap()
            for ((key, list) in prefixCount) {
                if (list.size >= k) {
                    val divNum = (list.size / k)
                    score += num * divNum
                    val left = list.size - (list.size * divNum)
                    prefixCount[key] = list.take(left)
                }
            }
            sList = sList.filter { it.length < num } + prefixCount.flatMap { it.value }
        }
        println("Case #$i: $score")
    }
}
