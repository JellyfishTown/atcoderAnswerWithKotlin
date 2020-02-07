package participated.agc041

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)

    if ((b - a) % 2 == 0L) {
        println((b - a) / 2)
        return
    }
    val left = a+(b-a-1)/2
    val right = (n-b+1)+(n-a-(n-b+1))/2
    println(Math.min(left,right))
}