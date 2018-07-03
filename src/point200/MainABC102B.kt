import java.io.BufferedWriter
import java.io.FileWriter
import java.io.PrintWriter

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val max = aList.max()!!
    val min = aList.min()!!
    println(max - min)
}

