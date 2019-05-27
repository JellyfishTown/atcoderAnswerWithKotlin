package participated.abc127

fun main(args: Array<String>) {
    var (r, d, x) = readLine()!!.split(' ').map(String::toLong)

    for(i in 1..10){
        x = r * x - d
        println(x)
    }
}
