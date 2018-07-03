fun main(args: Array<String>) {
    val s = readLine()!!.split("")
    println((s.count { it == "+" } - 2) * 2)
}

