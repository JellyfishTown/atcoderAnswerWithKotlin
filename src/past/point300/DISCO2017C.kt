fun main(args: Array<String>) {
    val (n, c) = readLine()!!.split(" ").map(String::toInt)
    val input = mutableListOf<Long>()
    val used = mutableListOf<Boolean>()
    for (i in 0 until n) {
        input.add(readLine()!!.toLong())
        used.add(false)
    }
    input.sort()
    var count = 0L
    for (i in 0 until (n - 1)) {
        if (used[i]) break
        for (j in (n - i - 1) downTo (i + 1)) {
            if (used[j]) continue
            if (input[i] + input[j] + 1 <= c) {
                count++
                used[i] = true
                used[j] = true
                break
            } else {
                count++
                used[j] = true
            }
        }
        if (!used[i]) {
            used[i] = true
            count++
            break
        }
    }
    println(count)
}