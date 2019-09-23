package past.other.internal.m4

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    var d = 1
    while (k shl d < 2 * n) {
        d++
    }
    println(d)

    for (td in 0 until d) {
        val array = Array(2 * n + 1) { 0 }
        val kn = k shl td
        for (i in 1..kn) {
            if (i + kn > 2 * n) break
            array[i] = i + kn
            array[i + kn] = i
        }
        for(i in 0 until (2*n-kn)/2){
            if(2*kn+1+i>2*n)break
            array[2*kn+1+i] = 2*n - i
            array[2*n - i] = 2*kn+1+i
        }
        for(i in 1..(2*n)){
            if(array[i]==0){
                array[i] = 2*n-i+1
            }
        }
        println(array.takeLast(2*n).joinToString(" "))
    }
}