fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    if (n == 0L) {
        println(0)
        return
    }
    var base = 2L
    var plusFlg = if (n > 0) 1L else -1L
    var rest = n
    val result = mutableListOf<Int>()

    while (rest != 0L) {
        if (rest % base != 0L) {
            rest -= (rest % base) * plusFlg
            result.add(1)

        } else {
            result.add(0)
        }
        plusFlg *= -1L
        base *= -2
    }
    result.reversed().forEach { print(it) }
    println()
}


//val baseList = mutableListOf<Long>()
//val plusList = mutableListOf<Long>()
//val minusList = mutableListOf<Long>()
//fun main(args: Array<String>) {
//    val n = readLine()!!.toLong()
//    if(n == 0L){
//        println(0)
//        return
//    }
//
//    var base = 1L
//    while (Math.abs(base) < 1100000000) {
//        baseList.add(base)
//        base *= -2
//    }
//
//    plusList.add(1L)
//    minusList.add(0)
//    for (i in 1 until baseList.size) {
//        if (baseList[i] > 0) {
//            plusList.add(plusList[i - 1] + baseList[i])
//            minusList.add(minusList[i - 1])
//        } else {
//            plusList.add(plusList[i - 1])
//            minusList.add(minusList[i - 1] + baseList[i])
//        }
//    }
//
//    val result = Array(31) { 0 }
//    var rest = n
//    for (i in 30 downTo 0) {
//        val plus = plusList[i]
//        val minus = minusList[i]
//        if (rest > 0) {
//            if ((plus + minus) > 0 && (plus - baseList[i]) <= rest && rest <= plus) {
//                rest -= baseList[i]
//                result[i] = 1
//            }
//        } else if (rest < 0) {
//            if ((plus + minus) < 0 && (minus - baseList[i]) >= rest && rest >= minus) {
//                rest -= baseList[i]
//                result[i] = 1
//            }
//        }
//    }
//    var flg = false
//    for(i in result.reversed()){
//        if(i==1){
//            print(1)
//            flg = true
//        }else if(i == 0 && flg){
//            print(0)
//        }
//    }
//
//    println()
//}


//    if (n > 0) {
//        val maxIndex = bList.indexOfFirst { it > n }
//        for (i in maxIndex..0) {
//            if (n > bList[i] / 2) {
//                result
//            } else {
//
//            }
//        }
//
//    } else if (n < 0) {
//
//    } else {
//        println(0)
//    }


//fun main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    for (i in 0..(n / 7)) {
//        if ((n - i * 7) % 4 == 0) {
//            println("Yes")
//            return
//        }
//    }
//    println("No")
//}

//
//fun main(args: Array<String>) {
//    val (n, k) = readLine()!!.split(' ').map(String::toInt)
//    if (n % k == 0) {
//        println(0)
//    } else {
//        println(1)
//    }
//}