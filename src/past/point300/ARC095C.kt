package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val x = readLine()!!.split(' ').map(String::toInt)
    val xsorted = x.sorted()
    val medianL = xsorted[n / 2 - 1]
    val medianH = xsorted[n / 2]
    for (i in 0..(n - 1)) {
        if(x[i]<=medianL){
            println(medianH)
        }else{
            println(medianL)
        }
    }
}

