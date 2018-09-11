fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(" ").map(String::toLong)
    if ((b - a) % 2L == 0L) {
        println("Alice")
    }else{
        println("Borys")
    }
}