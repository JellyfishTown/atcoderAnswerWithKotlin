package participated.abc141

fun main(args: Array<String>) {
    val s = readLine()!!
    if (s.filterIndexed { index, c -> index % 2 == 0 }.all { it == 'R' || it == 'U' || it == 'D' } && s.filterIndexed { index, c -> index % 2 == 1 }.all { it == 'L' || it == 'U' || it == 'D' }
    ) {
        println("Yes")
    } else {
        println("No")
    }
}