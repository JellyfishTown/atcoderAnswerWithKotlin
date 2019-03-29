fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toLong)
    val ls = mutableListOf<Pair<Long, Long>>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        ls.add(Pair(a, b))
    }
    ls.sortBy { it.first }
    var needs = m
    var cost = 0L
    for ((a, b) in ls) {
        if(needs < b){
            cost += needs * a
            break
        }else{
            cost += b * a
            needs -= b
        }
    }
    println(cost)
}
