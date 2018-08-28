package point300

fun main(args: Array<String>) {
    val str = readLine()!!
    var result: Long = 0

    for (i in 0 until str.length) {
        val no = Integer.parseInt(str[i].toString())
        for (j in 0 until str.length - i) {
            val temp = (no.toDouble()
                    * Math.pow(10.0, j.toDouble())
                    * Math.pow(2.0, i.toDouble())
                    * Math.pow(2.0, Math.max(str.length - 2 - j - i, 0).toDouble())
                    ).toLong()
            result += temp
            //println("i:$i,j:$j,no:$no,temp:$temp")
        }
    }
    println(result)
}