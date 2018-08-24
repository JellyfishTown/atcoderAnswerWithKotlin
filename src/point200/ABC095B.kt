package point200

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(" ").map(String::toInt)
    val mList = mutableListOf<Int>()
    for (i in (0..(n - 1))) {
        mList.add(readLine()!!.toInt())
    }
    val count = mList.size + (x - mList.sum()) / mList.min()!!

    println(count)
}