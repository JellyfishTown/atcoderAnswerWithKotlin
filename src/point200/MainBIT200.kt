fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var pList = mutableListOf<Int>()
    for (i in 0 until n) {
        pList.add(readLine()!!.toInt())
    }
    var count = 0
    while (true) {
        if(pList.all { it % 10 == 0 }){
            count++
            pList = pList.map{it / 10}.toMutableList()
        }else{
            break
        }
    }
    println(count)
}

