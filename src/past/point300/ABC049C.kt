fun main(args: Array<String>) {
    val words = listOf("dream", "dreamer", "erase", "eraser")
    val s = readLine()!!
    val sb = StringBuilder(s)
    while (sb.isNotEmpty()) {
        var deleted = false
        for (word in words) {
            if (sb.endsWith(word)) {
                sb.delete(sb.length - word.length, sb.length)
                deleted = true
            }
        }
        if (!deleted) break
    }
    println(if (sb.isEmpty()) "YES" else "NO")
}