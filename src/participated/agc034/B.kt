package participated.agc034

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    var count = 0L
    var aCount = 0
    for (i in 0..(s.size - 3)) {
        aCount = if (s[i] == 'A') aCount + 1 else 0
        if (s[i] == 'A' && s[i + 1] == 'B' && s[i + 2] == 'C') {
            s[i] = 'B'
            s[i + 1] = if (aCount > 1) 'A' else 'C'
            s[i + 2] = 'A'
            count += aCount
            aCount = Math.max(0, aCount - 2)
        }
    }
    println(count)
}


