package participated.abc149

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val (r, s, p) = readLine()!!.split(' ').map(String::toLong)
    val t = readLine()!!
    val hands = t.map {
        when (it) {
            'r' -> 'p'
            'p' -> 's'
            's' -> 'r'
            else -> 'x'
        }
    }.toMutableList()
    for(i in k until n){
        if(hands[i]==hands[i-k])hands[i]='x'
    }
    val ans = hands.map {
        when (it) {
            'r' -> r
            'p' -> p
            's' -> s
            else -> 0L
        }
    }.sum()
    println(ans)
}