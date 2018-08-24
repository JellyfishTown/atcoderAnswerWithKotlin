package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    var sqrt = Math.sqrt(n.toDouble()).toLong() + 1
    while (sqrt > 1) {
        if (n % sqrt == 0L) {
            val size1 = sqrt.toString().toCharArray().size
            val size2 = (n / sqrt).toString().toCharArray().size
            println(Math.max(size1, size2))
            return
        }
        sqrt--
    }
    println(n.toString().toCharArray().size)
}