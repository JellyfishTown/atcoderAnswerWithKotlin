package participated.abc134


fun main(args: Array<String>) {
     val (n, k) = readLine()!!.split(' ').map(String::toLong)
    if (k % 2 != 0L) {
        println(0)
        return
    }
    val mod = 1000000007
    val count = k.toInt() / 2
}
