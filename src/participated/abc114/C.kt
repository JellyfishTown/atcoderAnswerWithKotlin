package participated.abc114

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var count = 0
    val set = mutableSetOf(
            333, 335, 337, 353, 355, 357, 373, 375, 377,
            533, 535, 537, 553, 555, 557, 573, 575, 577,
            733, 735, 737, 753, 755, 757, 773, 775, 777
    )
    for (i in 1..6) {
        val temp = mutableSetOf<Int>().apply { addAll(set) }
        for (v in temp) {
            set.add((v.toString() + "3").toInt())
            set.add((v.toString() + "5").toInt())
            set.add((v.toString() + "7").toInt())
            set.add(("3" + v.toString()).toInt())
            set.add(("5" + v.toString()).toInt())
            set.add(("7" + v.toString()).toInt())
        }
    }
    val temp = set.filter { it.toString().contains('3')&&it.toString().contains('5') &&it.toString().contains('7')}
    println(temp.count { it <= n})
}
