package participated.abc156

fun main(args: Array<String>) {
    var (n, k) = readLine()!!.split(' ').map(String::toLong)
    var ans = 0
    while(n>0){
        n /= k
        ans++
    }
    println(ans)
}
