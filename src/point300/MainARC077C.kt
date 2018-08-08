package point300

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aQueue = ArrayDeque(readLine()!!.split(' ').map(String::toInt))
    val result = ArrayDeque<Int>()

    if (n % 2 == 1) {
        result.addFirst(aQueue.pop())
    }
    while (!aQueue.isEmpty()) {
        if (n % 2 == 1) {
            result.addLast(aQueue.pop())
            result.addFirst(aQueue.pop())
        } else {
            result.addLast(aQueue.pop())
            result.addFirst(aQueue.pop())
        }
    }
    println(result.toMutableList().joinToString(" "))
}
