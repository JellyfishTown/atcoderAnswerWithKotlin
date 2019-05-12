package participated.ext008


fun main(args: Array<String>) {
    val (r, g, b, n) = readLine()!!.split(' ').map(String::toLong)
    var sum = 0
    for (i in 0..3000) {
        if (i * r > n) break
        for (j in 0..3000) {
            if (i * r + j * g> n) break
            if ((n - i * r - j * g) % b == 0L) {
//                println("${i*r} ${j*g} ${(n - i * r - j * g) % b}")
                sum++
            }
        }
    }
    println(sum)
}
