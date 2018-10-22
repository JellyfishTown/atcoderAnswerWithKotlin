fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var sum = 0
    var out:Int
    var i = 1
    while (true) {
        sum += i
        if(sum>n){
            out = sum - n
            break
        }
        i++
    }

    for(j in 1..i){
        if(j!=out){
            println(j)
        }
    }
}