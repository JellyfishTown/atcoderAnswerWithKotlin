package participated.abc126

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val nd = n.toDouble()
    val two = (1..20).map { Math.pow(2.0, it.toDouble()) }
    var ans = 0.0
    for (i in 1..n) {
        if (i >= k) {
            ans += 1.0 / nd
        }else{
            for(j in 0..19){
                if(i*two[j]>=k){
                    ans+= 1 / (nd * two[j])
                    break
                }
            }
        }
    }
    println(ans)
}