package past.other.internal.m4

fun main(args: Array<String>) {
    var (n, x) = readLine()!!.split(' ').map(String::toLong)
    x = Math.abs(x)
    val dList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
//    val sum = dList.sum()
//    if (sum < x) {
//        println(x - sum)
//        return
//    }
//    val diff = sum - x
    var cur = 0L
    for (d in dList) {
        if (Math.abs(x - (cur - d)) < Math.abs(x - (cur + d))) {
            cur-=d
        }else{
            cur+=d
        }
    }

    println(Math.abs(x-cur))
}