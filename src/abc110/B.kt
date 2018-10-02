package abc110

fun main(args: Array<String>) {
    val (n, m, x, y) = readLine()!!.split(' ').map(String::toLong)
    val xList = readLine()!!.split(' ').map(String::toLong)
    val yList = readLine()!!.split(' ').map(String::toLong)
    val max = xList.max()!!
    if ((max < yList.min()!!) && (x < max) && (max < y)){
        println("No War")
    }else{
        println("War")
    }
}


