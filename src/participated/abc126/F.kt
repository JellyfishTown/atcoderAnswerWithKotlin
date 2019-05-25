package participated.abc126

fun main(args: Array<String>) {
    val (m, k) = readLine()!!.split(' ').map(String::toLong)
    val maxNum = Math.pow(2.0, m.toDouble()).toLong() - 1

    if(m == 1L){
        if(k>=1){
            println(-1)
        }else{
            println("0 0 1 1")
        }
        return
    }

    if (maxNum < k) {
        println(-1)
        return
    }

    for (i in 0..maxNum) {
        print((i + k + 1) % (maxNum + 1))
        print(" ")
    }
    for (i in 0 until maxNum) {
        print((k - i + maxNum) % (maxNum + 1))
        print(" ")
    }
    println(k)
}
