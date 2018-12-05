import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var count200 = 0
    var count300 = 0
    for (i in 0..(200 / n - 1)) {
        for (j in 0..(200 / n - 1)) {
            if (checkInner200(i * n, j * n)
                    && checkInner200((i + 1) * n, j * n)
                    && checkInner200(i * n, (j + 1) * n)
                    && checkInner200((i + 1) * n, (j + 1) * n)) {
                count200++
            }
        }
    }
    for (i in 0..(300 / n - 1)) {
        for (j in 0..(300 / n - 1)) {
            if (checkInner300(i * n, j * n)
                    && checkInner300((i + 1) * n, j * n)
                    && checkInner300(i * n, (j + 1) * n)
                    && checkInner300((i + 1) * n, (j + 1) * n)) {
                count300++
            }
        }
    }
    println("$count200 $count300")
}
private fun checkInner200(x: Int, y: Int) = (x - 100) * (x - 100) + (y - 100) * (y - 100) <= 10000
private fun checkInner300(x: Int, y: Int) =(x - 150) * (x - 150) + (y - 150) * (y - 150) <= 22500
