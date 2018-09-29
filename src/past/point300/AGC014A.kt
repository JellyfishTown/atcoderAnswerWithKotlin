fun main(args: Array<String>) {
    var (a, b, c) = readLine()!!.split(' ').map(String::toLong).sorted()
    var count = 0
    while (true) {
        if (a % 2 == 1L || b % 2 == 1L || c % 2 == 1L) {
            println(count)
            return
        } else if (a == b && b == c) {
            println(-1)
            return
        } else {
            count++
            val tempA = a
            val tempB = b
            val tempC = c
            a = (tempC + tempB) / 2
            b = (tempA + tempC) / 2
            c = (tempA + tempB) / 2
        }
    }
}

