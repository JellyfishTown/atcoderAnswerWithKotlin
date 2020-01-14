package past.point300

//https://atcoder.jp/contests/chokudai_S001/submissions/me
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xList = readLine()!!.split(' ').map(String::toInt)
    var max = 0
    var count = 0
    for(x in xList){
        if(x>max){
            max = x
            count++
        }
    }
    println(count)
}

