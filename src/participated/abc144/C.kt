package participated.abc144

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    for(i in (Math.sqrt(n.toDouble()).toLong()) downTo 1){
        if(n%i==0L){
            println(n/i+i-2)
            return
        }
    }
}