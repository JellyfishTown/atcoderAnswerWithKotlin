fun main(args: Array<String>) {
    val s = readLine()!!
    println(s.length - Math.abs(s.count { it == '0' } - s.count { it == '1' }))
}


