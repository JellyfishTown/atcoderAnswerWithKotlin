package participated.abc115

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hoge = mutableListOf<Int>()
    var sum = 0
    var max = 0
    for (i in 1..n) {
        val temp = readLine()!!.toInt()
        sum += temp
        max = Math.max(max, temp)
    }
    print(sum - max / 2)
}


