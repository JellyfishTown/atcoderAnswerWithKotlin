package participated.ext004

//https://nikkei2019-qual.contest.atcoder.jp/#
fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val data = mutableListOf<Triple<Long, Long, Long>>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        data.add(Triple(a + b, a, b))
    }
    data.sortBy { -it.first }
    var sum = 0L
    for (i in 1..n) {
        sum += if (i % 2 == 1L) data.first().second else -data.first().third
        data.removeAt(0)
    }
    println(sum)
}
