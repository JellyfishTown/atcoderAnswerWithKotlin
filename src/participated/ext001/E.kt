package participated.ext001

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).toLongArray()

    var times = 0L
    var toInt = times.toInt()
    while (aList[toInt] > aList[toInt + 1]) {
        aList[toInt] = aList[toInt] * -2
        times++
        toInt = times.toInt()
        if (toInt == (n - 1)) {
            println(times)
            return
        }
    }

    for (i in times.toInt() until (n - 1)) {
        if (aList[i] > aList[i + 1]) {
            val div = Math.sqrt(aList[i].toDouble() / aList[i + 1].toDouble() / 4)
            val divIsInt = (div % 1.0) == 0.0
            val intDiv = div.toLong()
            if (divIsInt) {
                aList[i + 1] = aList[i + 1] * (Math.pow(4.toDouble(), intDiv.toDouble())).toLong()
                times += intDiv * 2
            } else {
                aList[i + 1] = aList[i + 1] * (Math.pow(4.toDouble(), (intDiv + 1).toDouble())).toLong()
                times += (intDiv + 1) * 2
            }
        }
    }
    println(times)
}

