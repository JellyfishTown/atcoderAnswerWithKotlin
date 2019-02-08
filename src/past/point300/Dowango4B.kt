fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    var cnt = 0
    var max = 0
    for (i in 0 until s.size) {
        if (cnt < 0) {
            println(-1)
            return
        }
        cnt += if (s[i] == '2') 1 else -1
        max = Math.max(max, cnt)
    }
    if (cnt != 0) {
        println(-1)
    } else {
        println(max)
    }
}
