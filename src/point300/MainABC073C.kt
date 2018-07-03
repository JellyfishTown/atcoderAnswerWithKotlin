package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val set = mutableSetOf<Int>()
    for (i in 1..n) {
        val a = readLine()!!.toInt()
        if(set.contains(a)){
            set.remove(a)
        }else{
            set.add(a)
        }
    }
    println(set.size)
}

