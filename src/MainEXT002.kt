import java.util.*

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)
    var allSum = 0L
    val currentB = ArrayDeque<Long>()
    var min = Long.MAX_VALUE
    for (i in 1..n) {
        val b = readLine()!!.toLong()
        if(currentB.size<5){
            currentB.push(b)
        }else{
            currentB.pop()
            currentB.push(b)
        }
        min = Math.min(min,currentB.sum())
        allSum += b

    }
    println(allSum - min)

}
//
//fun main(args: Array<String>) {
//    val (c, d) = readLine()!!.split(" ").map(String::toLong)
//    val bpmlist = mutableListOf<Pair<Long, Long>>()
//    bpmlist.add(Pair(140,170))
//    for (i in 1..43) {
//        bpmlist.add(Pair(bpmlist[i - 1].first * 2, bpmlist[i - 1].second * 2))
//    }
//    var musicNum = 0L
//    for ((low, high) in bpmlist) {
//        when {
//            (c <= low && high <= d) -> {
//                musicNum += high - low
//            }
//            (low <= c && c <= high && high <= d) -> {
//                musicNum += high - c
//            }
//            (c <= low && low <= d && d <= high) -> {
//                musicNum += d - low
//            }
//        }
//    }
//    println(musicNum)
//}