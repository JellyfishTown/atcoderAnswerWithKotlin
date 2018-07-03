package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val cList = mutableListOf(0)
    val sList = mutableListOf(0)
    val fList = mutableListOf(0)
    for (i in 1..(n - 1)) {
        val (c, s, f) = readLine()!!.split(" ").map(String::toInt)
        cList.add(c)
        sList.add(s)
        fList.add(f)
    }

    for (i in 1..(n - 1)) {
        var t = 0L
        for (j in i..(n - 1)) {
            if (t <= sList[j]) {
                t = (sList[j] + cList[j]).toLong()
            } else if (t % fList[j] == 0L) {
                t += cList[j]
            } else {
                t += cList[j] + (fList[j] - t % fList[j])
            }
        }
        println(t)
    }
    println(0)
}
