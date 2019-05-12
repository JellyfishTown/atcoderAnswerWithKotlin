package participated.ext008


fun main(args: Array<String>) {
    val (n,k) = readLine()!!.split(' ').map(String::toLong)


    println(n-k+1)
}
