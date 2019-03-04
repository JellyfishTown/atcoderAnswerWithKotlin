fun main(args: Array<String>) {
    val s = readLine()!!
    val m = mutableMapOf<Char, Int>()
    for (c in readLine()!!) m[c] = m.getOrDefault(c, 0) + 1
    println(if (m.all { (k, v) -> v % 2 == 0 }) "Yes" else "No")
}
