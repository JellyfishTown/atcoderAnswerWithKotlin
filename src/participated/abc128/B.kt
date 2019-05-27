package participated.abc128
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val spList = mutableListOf<Triple<String,Int,Int>>()
    (1..n).forEach {
        val (s,p) = readLine()!!.split(' ')
        spList.add(Triple(s,p.toInt(),it))
    }
    spList.sortByDescending { it.second }
    spList.sortBy { it.first }
    spList.forEach { println(it.third) }
}
