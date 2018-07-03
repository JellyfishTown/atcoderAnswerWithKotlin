package point300

fun main(args: Array<String>) {
    val inputList = readLine()!!.split(' ').map(String::toInt)
    val (a, b, c, d) = inputList.subList(0, 4)
    val (e, f) = inputList.subList(4, 6)

    var noudo = 0.0
    var mizu = 0
    var sato = 0
    for (i1 in 0..(f/(100*a))) {
        for (i2 in 0..(f/(100*b))) {
            for (i3 in 0..(f/c)) {
                for (i4 in 0..(f/d)) {
                    if (i1 == 0 && i2 == 0) break
                    if (a * i1 * 100 + b * i2 * 100 + c * i3 + d * i4 > f) break
                    val n = (c * i3 + d * i4).toDouble() / (a * i1 * 100 + b * i2 * 100).toDouble()
                    if (n > (e.toDouble() / 100)) break
                    if (n > noudo) {
                        noudo = n
                        mizu = a * i1 * 100 + b * i2 * 100 + c * i3 + d * i4
                        sato = c * i3 + d * i4
                    }
                }
            }
        }
    }
    if(mizu == 0 )mizu = 100 *a
    println("$mizu $sato")
}
