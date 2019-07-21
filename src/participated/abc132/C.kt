package participated.abc132

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val d = readLine()!!.split(' ').map(String::toLong).sorted()
    val l = n/2 - 1
    val r = n/2
    if(d[l]==d[r]){
        println(0)
        return
    }
    println(d[r]-d[l])
}