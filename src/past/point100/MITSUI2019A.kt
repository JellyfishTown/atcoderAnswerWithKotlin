package past.point100

fun main(args: Array<String>) {
    val (m1,d1) = readLine()!!.split(' ').map(String::toLong)
    val (m2,d2) = readLine()!!.split(' ').map(String::toLong)

    if (m1!=m2) {
        println(1)
    } else {
        println(0)
    }
}
