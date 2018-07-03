import java.io.BufferedWriter
import java.io.FileWriter
import java.io.PrintWriter

fun main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    if (n % sumKeta(n) == 0){
//        println("Yes")
//    }else{
//        println("No")
//    }
    val fil = FileWriter("data.txt")
    val pw = PrintWriter(BufferedWriter(fil))
    for(i in 1..200000){
        val keta = sumKeta(i)
        pw.println("$i,$keta,${i.toDouble()/keta.toDouble()}")
    }
    pw.close()
}

fun sumKeta(num: Int): Int {
    val str = num.toString()
    var sum = 0
    str.forEach { sum += it.toString().toInt() }
    return sum
}