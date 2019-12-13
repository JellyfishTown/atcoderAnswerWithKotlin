package past.point400


//ワーシャルフロイド
fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val costMap = Array(10) { readLine()!!.split(' ').map(String::toInt).toIntArray() }
    for (i in 0..9) {
        for (j in 0..9) {
            for (k in 0..9) {
                costMap[j][k] = Math.min(costMap[j][k], costMap[j][i] + costMap[i][k])
            }
        }
    }
    val numCount = Array(10) { 0 }
    for (i in 1..h) {
        for (num in readLine()!!.split(' ').map(String::toInt)) {
            if (num != -1) numCount[num]++
        }
    }
    val cost = (0..9).map{numCount[it]*costMap[it][1]}.sum()
    println(cost)
}
