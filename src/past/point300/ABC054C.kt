package past.point300

fun main(args: Array<String>) {
    val (sx, sy, tx, ty) = readLine()!!.split(' ').map(String::toInt)
    val dx = tx - sx
    val dy = ty - sy

    (1..dy).forEach { print("U") }
    (1..dx).forEach { print("R") }

    (1..dy).forEach { print("D") }
    (1..dx).forEach { print("L") }

    print("L")
    (1..(dy+1)).forEach { print("U") }
    (1..(dx+1)).forEach { print("R") }
    print("D")

    print("R")
    (1..(dy+1)).forEach { print("D") }
    (1..(dx+1)).forEach { print("L") }
    print("U")
}
