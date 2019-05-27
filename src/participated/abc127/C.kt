package participated.abc127

fun main(args: Array<String>) {
    val (n,m) = readLine()!!.split(' ').map(String::toLong)
    val lList = mutableListOf<Long>()
    val rList = mutableListOf<Long>()
    for(i in 1..m){
    val (l,r) = readLine()!!.split(' ').map(String::toLong)
        lList.add(l)
        rList.add(r)
    }
    println(Math.max(0,rList.min()!! - lList.max()!!+1))
}
