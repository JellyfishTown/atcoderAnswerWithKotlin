fun main(args: Array<String>) {
    val N = readLine()!!.toLong()
    for (n in 1..3500) {
        for (h in 1..3500) {
            val w = (N * n * h).toDouble() / (4 * n * h - N * h - N * n).toDouble()
            if (w - Math.floor(w) == 0.0 && w > 0) {
                println("$n $h ${w.toLong()}")
                return
            }
        }
    }
}