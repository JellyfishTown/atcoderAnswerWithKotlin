package past.point400

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt)

    for(i in 0..k){
        var temp = 0
        aList.forEach { temp += i xor it }
        println("$i:$temp")
    }

}
