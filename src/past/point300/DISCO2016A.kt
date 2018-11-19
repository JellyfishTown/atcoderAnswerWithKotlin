fun main(args: Array<String>) {
    val (r, c) = readLine()!!.split(" ").map(String::toLong)
    var panelNum = 0L
    for (i in 1..(r / c)) {
        val height = Math.sqrt((r * r - c * c * i * i).toDouble())
        panelNum += height.toLong() / c
    }
    println(panelNum * 4)
}