package participated.ext003

//https://keyence2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val s = readLine()!!
    for (i in 0..7) {
        val left = "keyence".substring(0, i)
        val right = "keyence".substring(i)
        if (s.startsWith(left) && s.endsWith(right)) {
            println("YES")
            return
        }
    }
    println("NO")
}
