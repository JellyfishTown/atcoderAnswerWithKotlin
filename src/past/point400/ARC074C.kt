package past.point400

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toLong)
    var ans = Long.MAX_VALUE / 2
    if (h % 3 == 0L || w % 3 == 0L) ans = 0L
    if (h % 3 == 1L || h % 3 == 2L) ans = Math.min(ans, Math.abs(h * w * (h / 3 + 1) / h - h * w * (h / 3) / h))
    if (w % 3 == 1L || w % 3 == 2L) ans = Math.min(ans, Math.abs(h * w * (w / 3 + 1) / w - h * w * (w / 3) / w))
    var squares = arrayOf(h / 3 * w, (h - h / 3) * (w / 2), (h - h / 3) * (w - w / 2))
    ans = Math.min(ans, squares.max()!! - squares.min()!!)

    squares = arrayOf((h / 3 + 1) * w, (h - (h / 3 + 1)) * (w / 2), (h - (h / 3 + 1)) * (w - w / 2))
    ans = Math.min(ans, squares.max()!! - squares.min()!!)

    squares = arrayOf(w / 3 * h, (w - w / 3) * (h / 2), (w - w / 3) * (h - h / 2))
    ans = Math.min(ans, squares.max()!! - squares.min()!!)

    squares = arrayOf((w / 3 + 1) * h, (w - (w / 3 + 1)) * (h / 2), (w - (w / 3 + 1)) * (h - h / 2))
    ans = Math.min(ans, squares.max()!! - squares.min()!!)

    println(ans)
}
