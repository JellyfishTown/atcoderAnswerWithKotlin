package participated.abc167

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val a = readLine()!!.split(' ').map(String::toInt).toMutableList()
    a.add(0, 0)
    val visited = LongArray(n.toInt() + 1) { 0 }

    var start = 0L
    var end = 0L
    var cur = 1
    for (i in 1..n) {
        if (visited[cur] != 0L) {
            start = visited[cur]
            end = i
            break
        } else {
            visited[cur] = i
            cur = a[cur]
        }
    }

    cur = 1
    if (k <= start) {
        for (i in 0 until k) {
            cur = a[cur]
        }
    } else {
        val tk = (k - start + 1) % (end - start)
        for (i in 0 until (start - 1)) {
            cur = a[cur]
        }
        for (i in 0 until tk) {
            cur = a[cur]
        }
    }
    println(cur)
}
