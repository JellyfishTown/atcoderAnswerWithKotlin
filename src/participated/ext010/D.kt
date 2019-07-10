package participated.ext010

var a = listOf<Long>()
var b = listOf<Long>()

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    a = readLine()!!.split(' ').map(String::toLong)
    b = readLine()!!.split(' ').map(String::toLong)

    //a->b
    var maxAB = 0L
    maxAB = Math.max(maxAB, calcMaxAB(n, 0, 1, 2, a, b))
    maxAB = Math.max(maxAB, calcMaxAB(n, 0, 2, 1, a, b))
    maxAB = Math.max(maxAB, calcMaxAB(n, 1, 0, 2, a, b))
    maxAB = Math.max(maxAB, calcMaxAB(n, 1, 2, 0, a, b))
    maxAB = Math.max(maxAB, calcMaxAB(n, 2, 0, 1, a, b))
    maxAB = Math.max(maxAB, calcMaxAB(n, 2, 1, 0, a, b))

    var maxBA = 0L
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 0, 1, 2, b, a))
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 0, 2, 1, b, a))
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 1, 0, 2, b, a))
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 1, 2, 0, b, a))
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 2, 0, 1, b, a))
    maxBA = Math.max(maxBA, calcMaxAB(maxAB, 2, 1, 0, b, a))
    println(maxBA)
}

fun calcMaxAB(n: Long, one: Int, two: Int, three: Int, a: List<Long>, b: List<Long>): Long {
    var tempN = n
    var tempG = 0L
    var tempS = 0L
    var tempB = 0L

    var max = 0L

    for (i in 0..(n / a[one])) {
        var tempNi = n
        tempG = tempNi / a[one]
        tempNi %= a[one]
        for (j in 0..(tempNi / a[two])) {
            var tempNj = tempNi
            tempS = tempNj / a[two]
            tempNj %= a[two]
            for (k in 0..(tempNj / a[three])) {
                tempB = tempNj / a[three]
                max = Math.max(max, tempG * b[one] + tempS * b[two] + tempB * b[three])
            }
        }
    }
    return max
}
