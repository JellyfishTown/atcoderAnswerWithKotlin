package point600
//不正解
fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (a, b, c, d) = readLine()!!.split(' ').map(String::toLong)
        val start = Math.max(a - b * Math.ceil((a - c).toDouble() / b.toDouble()).toLong(), a % b)
        when {
            (a < b) || (d < b) || (a % b > c) || (start < b) -> {
                println("No")
            }
            (d == b) -> {
                println("Yes")
            }
            else -> {
                val left = (c - start).toDouble() / (d - b).toDouble()
                val right = (b - start).toDouble() / (d - b).toDouble()
                var ceil = Math.ceil(left)
                var floor = Math.floor(right)
                if (ceil == left) ceil++
                if (floor == right) floor--
                if (ceil <= floor) {
                    println("No")
                } else {
                    println("Yes")
                }
            }
        }
    }
}
