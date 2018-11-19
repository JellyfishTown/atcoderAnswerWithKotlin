fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val s = readLine()!!.toCharArray()
    val countB = s.count { it == 'B' }
    when (countB) {
        0 -> println(((1L + n * s.size) * n * s.size / 2L))
        s.size -> println(0)
        else -> {
            var oneTime = 0L
            var temp = 1L
            s.forEach {
                if (it == 'A') {
                    oneTime += temp++
                } else {
                    temp = 1L
                }
            }
            val left = s.indexOfFirst { it == 'B' }.toLong()
            val right = s.size - s.indexOfLast { it == 'B' }.toLong() - 1
            println(n * oneTime + left * right * (n - 1))
        }
    }
}
