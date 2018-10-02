package participated.abc102


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toInt)
    val aAccum = mutableListOf(aList[0].toLong())
    for (i in 1 until n) {
        aAccum.add(aAccum[i - 1] + aList[i])
    }
    var min = Long.MAX_VALUE
    var left = 0
    var right = 2
    for (center in 1 until (n - 2)) {

        var lDiff = Long.MAX_VALUE
        for (l in left until center) {
            val diff = Math.abs(aAccum[center] - aAccum[l] - aAccum[l])
            if (lDiff > diff) {
                lDiff = diff
                left = l
            } else {
                break
            }
        }

        var rDiff = Long.MAX_VALUE
        for (r in right until (n - 1)) {
            val diff = Math.abs((aAccum[aAccum.size - 1] - aAccum[r]) - (aAccum[r] - aAccum[center]))
            if (rDiff > diff) {
                rDiff = diff
                right = r
            } else {
                break
            }
        }

        val s1 = aAccum[left]
        val s2 = aAccum[center] - aAccum[left]
        val s3 = (aAccum[right] - aAccum[center])
        val s4 = (aAccum[aAccum.size - 1] - aAccum[right])
        val tempMax = Math.max(Math.max(s1, s2), Math.max(s3, s4))
        val tempMin = Math.min(Math.min(s1, s2), Math.min(s3, s4))
        min = Math.min(min,tempMax-tempMin)
    }
    println(min)
}
