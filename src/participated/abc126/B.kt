package participated.abc126

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val first = s.slice(0..1).joinToString("").toInt()
    val second = s.slice(2..3).joinToString("").toInt()
    if(first in 1..12&&second in 1..12){
        println("AMBIGUOUS")
    }else if(first in 1..12){
        println("MMYY")
    }else if(second in 1..12){
        println("YYMM")
    }else{
        println("NA")
    }
}