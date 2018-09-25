import java.util.*

fun main(args: Array<String>) {
    val stack = Stack<Char>()
    for (c in readLine()!!) {
        if (stack.empty() || stack.peek() == 'T' || c == 'S') {
            stack.push(c)
        } else {
            stack.pop()
        }
    }
    println(stack.size)
}