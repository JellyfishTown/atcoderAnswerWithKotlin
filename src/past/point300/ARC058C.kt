package past.point300


fun main(args: Array<String>) {
    val n = readLine()!!.split(' ').map(String::toInt).first()
    val dList = readLine()!!.split(' ').map { it.toCharArray().first() }
    for (i in n until 100000) {
        if(i.toString().toCharArray().all { dList.contains(it).not() }){
            println(i)
            break
        }
    }
}

