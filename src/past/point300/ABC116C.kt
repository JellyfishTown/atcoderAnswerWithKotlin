fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = readLine()!!.split(" ").map(String::toInt).toMutableList()
    var i = 0
    var left = 0
    var count = 0
    var countFlag = false
    while (h.sum() > 0) {
        if (h[i] > 0) {
            h[i]--
            i++
            if (!countFlag) {
                count++
                countFlag = true
            }

        } else if (h[i] == 0 && countFlag) {
            i = left
            countFlag = false

        } else {
            left = i
            i++
        }

        if (i == n) {
            i = left
            countFlag = false
        }
    }
    println(count)
}

