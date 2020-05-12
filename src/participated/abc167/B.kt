package participated.abc167

fun main(args: Array<String>) {
    val (a, b, c, k) = readLine()!!.split(' ').map(String::toInt)
    val list = mutableListOf<Int>()
    if(k<=a){
        println(k)
    }else if(k<=a+b){
        println(a)
    }else{
        println(a-(k-a-b))
    }
}
