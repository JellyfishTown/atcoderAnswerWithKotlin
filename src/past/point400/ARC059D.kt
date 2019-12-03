package past.point400


fun main(args: Array<String>) {
    val s = readLine()!!
    for (i in 0..(s.length - 2)) {
        if (s[i] == s[i + 1]) {
            println("${i+1} ${i+2}")
            return
        }
    }
    for (i in 0..(s.length - 3)) {
        if (s[i] == s[i + 2]) {
            println("${i+1} ${i+3}")
            return
        }
    }
    println("-1 -1")
}
