fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)
    val i = (n - 1) / (k - 1) + if ((n - 1) % (k - 1) == 0) 0 else 1
    println(i)
}

