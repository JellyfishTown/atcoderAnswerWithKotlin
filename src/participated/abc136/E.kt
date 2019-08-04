package participated.abc136

fun main(args: Array<String>) {
    fun divisor(n: Long): List<Long> {
        val list = mutableListOf<Long>()
        var i = 1L
        while (i * i <= n) {
            if (n % i == 0L) {
                list.add(i)
                if (i != n / i) {
                    list.add(n / i)
                }
            }
            i++
        }
        return list.sortedDescending()
    }

    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val divList = divisor(aList.sum())

    for (div in divList) {
        val modList = aList.map { it % div }.filter { it != 0L }.sorted()
        val modDivList = modList.map { div - it }
        if(modList.isEmpty()){
            println(div)
            return
        }else if(modList.size == 1){
            continue
        }

        val modRuiseki = mutableListOf(modList[0])
        (1 until modList.size).forEach { modRuiseki.add(modList[it] + modRuiseki[it - 1]) }
        val modDivRuiseki = mutableListOf(modDivList.last())
        (modDivList.size -2 downTo 0).forEach { modDivRuiseki.add(0,modDivList[it] + modDivRuiseki[0]) }

        for(i in 0 until modRuiseki.size-1){
            if(modRuiseki[i]<=k &&  modRuiseki[i]==modDivRuiseki[i+1]){
                println(div)
                return
            }
        }
    }
    println(1)
}

//var moveCountM = 0L
//var moveCountP = 0L
//for (i in 0 until n.toInt()) {
//    val a = aList[i]
//
//    val toMinus = a % div
//    if(toMinus==0L)continue
//    val toPlus = div - toMinus
//    if (div / 2 >= toMinus) {
//        moveCountM += toMinus
//        if (moveCountM > k) {
//            moveCountM -= toMinus
//            moveCountP += toPlus
//        }
//    } else {
//        moveCountP += toPlus
//        if (moveCountP > k) {
//            moveCountP -= toPlus
//            moveCountM += toMinus
//        }
//    }
//    if (moveCountM + moveCountP > 2 * k) {
//        break
//    }
//}
//if (moveCountM + moveCountP > 2 * k) {
//    continue
//} else {
//    println(div)
//    return
//}