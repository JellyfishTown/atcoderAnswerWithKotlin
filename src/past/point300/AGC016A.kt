fun main(args: Array<String>) {
    val s = readLine()!!
    var minNum = Int.MAX_VALUE
    val sDis = s.toCharArray().distinct()
    for (c in sDis) {
        var temp = s.toMutableList()
        var count = 0
        while (true) {
            val newTemp = mutableListOf<Char>()
            if (temp.distinct().size == 1) {
                break
            }
            for (i in 0 until temp.size - 1) {
                if (temp[i] == c) {
                    newTemp.add(temp[i])
                } else {
                    newTemp.add(temp[i + 1])
                }
            }
            count++
            temp = newTemp
        }
        minNum = Math.min(minNum, count)
    }
    println(minNum)
}
