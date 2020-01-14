package past.point300

//https://atcoder.jp/contests/jsc2019-final-open/tasks/jsc2019_final_a
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt)
    val bList = readLine()!!.split(' ').map(String::toInt)

    val heavyArray = Array(2000001) { "" }
    for (i in 0 until n) {
        for (j in 0 until m) {
            val sum = aList[i]+bList[j]
            if(heavyArray[sum]!=""){
                println("${heavyArray[sum]} $i $j")
                return
            }
            heavyArray[sum] = "$i $j"
        }
    }
    println(-1)
}

