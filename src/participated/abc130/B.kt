package participated.abc130
fun main(args: Array<String>) {
    val (n,x) = readLine()!!.split(' ').map(String::toLong)
    val lList = readLine()!!.split(' ').map(String::toLong)
    val dList = mutableListOf<Long>()
    dList.add(0)
    (1..n).forEach { dList.add(dList[it.toInt()-1]+lList[it.toInt()-1]) }
    println(dList.count { it<=x })
}
