package participated.abc149

fun main(args: Array<String>) {
    fun isPrimeFast(num: Long): Boolean {
        if (num < 2)
            return false
        else if (num == 2L)
            return true
        else if (num % 2L == 0L)
            return false
        val sqrtNum = Math.sqrt(num.toDouble())
        var i = 3
        while (i <= sqrtNum) {
            if (num % i == 0L) {
                return false
            }
            i += 2
        }
        return true
    }

    val x = readLine()!!.toLong()
    if(x<=2){
        println(2)
        return
    }
    var i = x + if (x % 2 == 0L) 1 else 0
    while(true){
        if(isPrimeFast(i)){
            println(i)
            return
        }
        i++
    }
}