package participated.abc127


fun main(args: Array<String>) {
    val q = readLine()!!.toInt()
    val aList = mutableListOf<Long>()
    var b = 0L
    for (i in 1..q) {
        val input = readLine()!!
        if (input.contains(' ')) {
            val (z, ta, tb) = input.split(' ').map(String::toLong)
            b += tb
//            aList.add(aList.toTypedArray().lowerBound(ta),ta)
        } else {
            val med = aList[(aList.size - 1) / 2]
            print(med)
            print(" ")
            println(aList.map { Math.abs(it - med) }.sum() + b)
        }
    }
}

