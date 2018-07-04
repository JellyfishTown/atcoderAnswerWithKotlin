package point300

fun main(args: Array<String>) {
    val inputList = readLine()!!.split(' ').map(String::toInt)
    val (a, b, c, d) = inputList.subList(0, 4)
    val (e, f) = inputList.subList(4, 6)

    var concentration = 0.0
    var all = 0
    var sugar = 0
    for (ia in 0..(f / (100 * a))) {
        for (ib in 0..(f / (100 * b))) {
            for (ic in 0..(f / c)) {
                for (id in 0..(f / d)) {
                    if (ia == 0 && ib == 0) break
                    val tempWater = a * ia * 100 + b * ib * 100
                    val tempSugar = c * ic + d * id
                    val tempAll = tempWater + tempSugar
                    if (tempAll > f) break
                    val tempConcentration = 100.0 * tempSugar.toDouble() / tempWater.toDouble()
                    if (tempConcentration > e.toDouble()) break
                    if (tempConcentration > concentration) {
                        concentration = tempConcentration
                        all = tempAll
                        sugar = tempSugar
                    }
                }
            }
        }
    }
    if (all == 0) all = 100 * a
    println("$all $sugar")
}
